package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.CouponData;
import com.ruoyi.system.domain.CouponInfo;
import com.ruoyi.system.domain.CouponManagerRequest;
import com.ruoyi.system.domain.CouponManagerResponse;
import com.ruoyi.system.domain.CouponRequest;
import com.ruoyi.system.domain.CouponResponse;
import com.ruoyi.system.domain.CouponView;
import com.ruoyi.system.domain.DmCoupon;
import com.ruoyi.system.domain.LoginRequest;
import com.ruoyi.system.domain.LoginResponse;
import com.ruoyi.system.domain.NoticeRequest;
import com.ruoyi.system.domain.QueryResponse;
import com.ruoyi.system.domain.ReturnResponse;
import com.ruoyi.system.domain.UnUseRequest;
import com.ruoyi.system.domain.UsedRequest;
import com.ruoyi.system.domain.UsedResponse;
import com.ruoyi.system.mapper.DmCouponMapper;
import com.ruoyi.system.mapper.CouponDao;
import com.ruoyi.system.service.IDmCouponService;

import com.ruoyi.common.utils.http.HttpUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 云闪付券码查询Service业务层处理
 * 
 * @author K7L
 * @date 2022-03-15
 */
@Service
public class DmCouponServiceImpl implements IDmCouponService 
{
    @Autowired
    private DmCouponMapper dmCouponMapper;

    /**
     * 查询云闪付券码查询
     * 
     * @param id 云闪付券码查询主键
     * @return 云闪付券码查询
     */
    @Override
    public DmCoupon selectDmCouponById(Long id)
    {
        return dmCouponMapper.selectDmCouponById(id);
    }

    /**
     * 查询云闪付券码查询列表
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 云闪付券码查询
     */
    @Override
    public List<DmCoupon> selectDmCouponList(DmCoupon dmCoupon)
    {
        return dmCouponMapper.selectDmCouponList(dmCoupon);
    }

    /**
     * 新增云闪付券码查询
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    @Override
    public int insertDmCoupon(DmCoupon dmCoupon)
    {
        return dmCouponMapper.insertDmCoupon(dmCoupon);

      
    }

    /**
     * 修改云闪付券码查询
     * 这里进行判断控制
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    @Override
    public int updateDmCoupon(DmCoupon dmCoupon)
    {
        //对状态进行判断，只有已发送的，可以改为已核销，其他都不能修改
        //0：未使用；1：已发送；2：已退款；：3：已核销；
        
        if ( dmCoupon.getState() == 1)
        {
            //这里加银联接口
            UsedRequest req = new UsedRequest();
            req.setCoupon_id(dmCoupon.getCouponId());
            req.setCoupon_code(dmCoupon.getCouponCode());
            UsedResponse res = this.useCoupon(req);

            if (res.getRsp_code().equals("00") ){
                return 1;
            } return 0;
            // dmCoupon.setState((long) 3);
            // return dmCouponMapper.updateDmCoupon(dmCoupon);
       
        // 
        }
        return 0;//返回一条数据
    }

    /**
     * 批量删除云闪付券码查询
     * 
     * @param ids 需要删除的云闪付券码查询主键
     * @return 结果
     */
    @Override
    public int deleteDmCouponByIds(String ids)
    {
        return dmCouponMapper.deleteDmCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除云闪付券码查询信息
     * 
     * @param id 云闪付券码查询主键
     * @return 结果
     */
    @Override
    public int deleteDmCouponById(Long id)
    {
        return dmCouponMapper.deleteDmCouponById(id);
    }
    
    /**
     * Created by fengfeng on 2020/9/18.
     */
    //@Service
    //public class CouponServiceImpl implements ICouponService {
    
        @Value("${unionpay.svc_id}")
        private String svc_id ;
    
    
        @Value("${unionpay.MD5key}")
        private String key;
    
        @Value("${unionpay.couponid}")
        private String couponId;
    
        //@Autowired
        //CouponDao couponDao;
    
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd000000");


        @Autowired
        CouponDao couponDao;
    
        @Override
        public CouponResponse fetchCoupon(CouponRequest req) {//银联来取券码，已卖
            System.out.println("fetch_req:"+ JSONObject.toJSONString(req));//等于日志
            CouponData dataQuery = new CouponData();
            dataQuery.setOrder_no(req.getOrder_no());
            dataQuery.setCoupon_id(req.getCoupon_id());
            List<CouponData> dataList= this.couponDao.findByOrder(dataQuery);
            Calendar cl = Calendar.getInstance();
            String begin = simpleDateFormat.format(cl.getTime());
            cl.add(Calendar.YEAR,1);
            String end  = simpleDateFormat.format(cl.getTime());
            CouponResponse response = new CouponResponse();
            List<CouponInfo> list =new ArrayList<>();
            if(dataList == null || dataList.size()==0){
                list = new ArrayList<>();
                dataList = this.couponDao.findNew(req);
                System.out.println("Find New");
                if(dataList.size()<req.getBuy_qty()){
                    response.setRsp_code("UP-99");
                    response.setRsp_msg("没有足够的券");
                    response.makeSign();
                    return response;
                }
                for(int i = 0 ; i<dataList.size();i++) {
                    CouponData data = dataList.get(i);
                    if(data.getEffective_tm()==null) {
                        data.setEffective_tm(begin);
                    }
                    if(data.getExpire_tm() ==null) {
                        data.setExpire_tm(end);
                    }
                    CouponInfo info = new CouponInfo();
                    info.setCoupon_code(data.getCoupon_code());
                    info.setEffective_tm(data.getEffective_tm());
                    info.setExpire_tm(data.getExpire_tm());
                    list.add(info);
                    data.setOrder_no(req.getOrder_no());
                    data.setTxn_time(req.getTxn_time());
                    data.setState(1);
                    data.setGift_mall_no(req.getGift_mall_no());
                    data.setSvc_trans_id("T"+cl.getTimeInMillis());
                    response.setSvc_trans_id(data.getSvc_trans_id());
                    this.couponDao.updateCoupon(data);
                }
            }else{
                System.out.println("Query BY DB");
                list = new ArrayList<>();
                for(int i = 0 ; i<dataList.size();i++) {
                    CouponData data = dataList.get(i);
                    CouponInfo info = new CouponInfo();
                    info.setCoupon_code(data.getCoupon_code());
                    info.setEffective_tm(begin);
                    info.setExpire_tm(end);
                    response.setSvc_trans_id(data.getSvc_trans_id());
                    list.add(info);
                }
            }
            response.setTxn_time(req.getTxn_time());
            response.setOrder_no(req.getOrder_no());
            response.setCouponInfos(list);
            response.setCoupon_id(req.getCoupon_id());
            response.setTxn_type(req.getTxn_type());
            response.setSvc_id( this.svc_id);
            response.setKey(this.key);
            response.makeSign();
            return response;
        }
    
        @Override
        public ReturnResponse returnCoupon(CouponRequest req) {
            System.out.println("return_req:"+ JSONObject.toJSONString(req));
            ReturnResponse response = new ReturnResponse();
            CouponData data = this.couponDao.queryByCode(req);
            Calendar cl = Calendar.getInstance();
            response.setSvc_trans_id("T"+cl.getTimeInMillis());
            if(data ==null ){
                response.setRsp_code("03");
                response.setRsp_msg("券不存在");
            }
            else if(data.getState() >= 3){
              response.setRsp_code("02");
              response.setRsp_msg("该券已被使用，不能退回。");
            }else{
                data.setState(2);//已退货
                data.setSvc_trans_id(response.getSvc_trans_id());
                this.couponDao.updateCoupon(data);
            }
            response.setCoupon_code(req.getCoupon_code());
            response.setTxn_time(req.getTxn_time());
            response.setOrder_no(req.getOrder_no());
            response.setCoupon_id(req.getCoupon_id());
            response.setTxn_type(req.getTxn_type());
            response.setSvc_id( this.svc_id);
            response.setKey(this.key);
            response.makeSign();
            return response;
        }
    
        @Override
        public QueryResponse queryCoupon(CouponRequest req) {
            System.out.println("query_req:"+ JSONObject.toJSONString(req));
            QueryResponse response = new QueryResponse();
            CouponData data = this.couponDao.queryByCode(req);
            Calendar cl = Calendar.getInstance();
            response.setSvc_trans_id("T"+cl.getTimeInMillis());
            if(data ==null ){
                response.setRsp_code("03");
                response.setRsp_msg("券不存在");
            }else {
                response.setCoupon_st("" + data.getState());
                response.setEffective_tm(data.getEffective_tm());
                response.setExpire_tm(data.getExpire_tm());
            }
            response.setCoupon_code(req.getCoupon_code());
    //        response.setTxn_time(req.getTxn_time());
            response.setCoupon_id(req.getCoupon_id());
            response.setTxn_type(req.getTxn_type());
            response.setSvc_id( this.svc_id);
            response.setKey(this.key);
            response.makeSign();
            return response;
        }
    
    
    
        @Value("${unionpay.uri}")
        private String uri;
    
        @Override
        public UsedResponse useCoupon(UsedRequest req) {
            System.out.println(JSONObject.toJSONString(req));
            SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddHHmmss");
            req.setTxn_time(sp.format(Calendar.getInstance().getTime()));
            if(req.getCoupon_id()==null) {
                req.setCoupon_id(this.checkCouponId(req.getCoupon_code()));
            }
            req.setTxn_type("VFY-CPN");
            req.setSvc_id(this.svc_id);
            req.setKey(this.key);
            req.setOrder_no("T" + Calendar.getInstance().getTimeInMillis());
            req.setVerify_tm(req.getTxn_time());
            req.makeSign();
            // String res = HttpUtil.doPost(null, JSONObject.toJSONString(req), this.uri + "vfy_cpn", null, null, null);
            // System.out.println(res);
            // UsedResponse usedResponse

            UsedResponse usedResponse = new UsedResponse();
            try {
                // usedResponse = JSONObject.parseObject(res, UsedResponse.class);
                if ("00".equals(usedResponse.getRsp_code())) {
                    CouponData data = new CouponData();
                    data.setCoupon_code(req.getCoupon_code());
                    data.setState(3);
                    this.couponDao.updateState(data);
                }
            } catch (Exception ex) {
                usedResponse = new UsedResponse();
                usedResponse.setRsp_code("-1");
                usedResponse.setRsp_msg("银联核销失败");
            }
            return usedResponse;
        }
    
        @Override
        public UsedResponse unUseCoupon(UnUseRequest req) {
            SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddHHmmss");
            req.setTxn_time(sp.format(Calendar.getInstance().getTime()));
            if(req.getCoupon_id()==null) {
                req.setCoupon_id(this.checkCouponId(req.getCoupon_code()));
            }
            req.setTxn_type("RVK-VFY");
            req.setSvc_id(this.svc_id);
            req.setKey(this.key);
            req.setOrder_no("T" + Calendar.getInstance().getTimeInMillis());
            req.setRvk_vfy_tm(req.getTxn_time());
            req.makeSign();
            String res = HttpUtil.doPost(null, JSONObject.toJSONString(req), this.uri + "rvk_vfy", null, null, null);
            UsedResponse usedResponse;
            try {
                 usedResponse = JSONObject.parseObject(res, UsedResponse.class);
                if ("00".equals(usedResponse.getRsp_code())) {
                    CouponData data = new CouponData();
                    data.setCoupon_code(req.getCoupon_code());
                    data.setState(2);  //这里应该是核销，为什么try catch
                    this.couponDao.updateState(data);
                }
            }catch (Exception ex){
                usedResponse = new   UsedResponse();
                usedResponse.setRsp_code("-1");
                usedResponse.setRsp_msg("银联核销冲正失败");
            }
            return usedResponse;
        }
    
        private String  checkCouponId(String  couponCode) {
    
                CouponRequest couponRequest = new CouponRequest();
                couponRequest.setCoupon_code(couponCode);
                CouponData dt = this.couponDao.queryByCode(couponRequest);
              return dt.getCoupon_id();
        }
    
        @Override
        public void notice(NoticeRequest req) {
            req.setTxn_type("INV-NTC");
            req.setSvc_id(this.svc_id);
            req.setKey(this.key);
            req.makeSign();
            String res = HttpUtil.doPost(null,JSONObject.toJSONString(req),this.uri+"inv_cpn",null,null,null);
            System.out.println(res);
        }
    
        @Override
        public CouponManagerResponse queryCouponLocal(CouponManagerRequest request) {
            List<CouponData> list = this.couponDao.queryList(request);
            List<CouponView> viewList = new ArrayList<>();
            for(CouponData data :list){
                CouponView view = new CouponView();
                view.set优惠ID(data.getCoupon_id());
                view.set优惠码(data.getCoupon_code());
                view.set开始时间(data.getEffective_tm());
                view.set截止时间(data.getExpire_tm());
                view.set订单号码(data.getOrder_no());
                view.set订单时间(data.getTxn_time());
                switch (data.getState()) {
                    case 0:
                        view.set优惠码状态("未发送");
                        break;
                    case 1:
                        view.set优惠码状态("已发送");
                        break;
                    case 2:
                        view.set优惠码状态("已退货");
                        break;
                    case 3:
                        view.set优惠码状态("已核销");
                        break;
                    case 4:
                        view.set优惠码状态("已冻结");
                        break;
                    case 5:
                        view.set优惠码状态("已作废");
                        break;
                    case 6:
                        view.set优惠码状态("已过期");
                        break;
                }
                viewList.add(view);
            }
            CouponManagerResponse response = new CouponManagerResponse();
            response.setDatas(viewList);
            return response;
        }
    
        @Override
        public LoginResponse login(LoginRequest request) {
            LoginResponse response = new LoginResponse();
            if (!request.getUserName().equals("chenx") || !"123".equals(request.getPassword())) {
                response.setState(-1);
                response.setComment("账号密码错误");
            }
            return response;
        }
    
        @Override
        public CouponManagerResponse addCoupons(CouponManagerRequest request) {
            String[] codes = request.getCodes().split("\n");
            for(String code:codes){
                CouponData data = new CouponData();
                data.setCoupon_id(request.getCoupon_id());
                data.setCoupon_code(code);
                this.couponDao.addCoupon(data);
            }
            return new CouponManagerResponse();
        }
    
    
        public static String getMd5(String filePath) throws FileNotFoundException {
            String value = null;
            FileInputStream in = null;
            File file = new File(filePath);
            try {
                in = new FileInputStream(file);
                MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(byteBuffer);
                BigInteger bi = new BigInteger(1, md5.digest());
                value = bi.toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        return value;
    }
}
    


