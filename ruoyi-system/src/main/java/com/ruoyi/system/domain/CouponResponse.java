package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by fengfeng on 2020/9/18.
 */
@Data
public class CouponResponse  extends ResBase{


    private String coupon_list;


    @JsonIgnore
    private List<CouponInfo> couponInfos;

    private String coupon_style="0";

    protected String txn_time;

    protected String order_no;

    /**
     * coupon_id=CPN1002&coupon_list=[{"add_info":"13564803184","coupon_code":"CPNCD01","coupon_pass":"","effective_tm":"20191001","expire_tm":"20191010"}]
     * &coupon_style=0&
     * encoding=UTF-8
     * &order_no=2019081510090001&
     * rsp_code=00&
     * rsp_msg=SUCCESS&
     * srv_id=SRVID8001&
     * svc_trans_id=transId20190001&
     * txn_time=20190815100900
     * &txn_type=REQ-CPN
     * &version=1.0.0&key=shangfu2019
     */
    public void makeSign(){

        StringBuffer sb = new StringBuffer();

        StringBuffer sbList = new StringBuffer("[");
        sb.append("coupon_id=").append(this.coupon_id);
        sb.append("&coupon_list=");
        for(int i= 0 ;this.couponInfos!=null&& i<this.couponInfos.size();i++){
           if(i>0){
               sbList.append(",");
           }
            sbList.append(this.couponInfos.get(i).fatchSign());
        }
        sbList.append("]");
        this.coupon_list = sbList.toString();
        sb.append(this.coupon_list);
        sb.append("&coupon_style=").append(this.coupon_style);
        sb.append("&encoding=").append(this.encoding);
        sb.append("&order_no=").append(this.order_no);
        sb.append("&rsp_code=").append(this.rsp_code);
        sb.append("&rsp_msg=").append(this.rsp_msg);
        sb.append("&svc_id=").append(this.svc_id);
        sb.append("&svc_trans_id=").append(this.svc_trans_id);
        sb.append("&txn_time=").append(this.txn_time);
        sb.append("&txn_type=").append(this.txn_type);
        sb.append("&version=").append(this.version);
        sb.append("&key=").append(this.key);
        System.out.println(sb.toString());
        this.sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
    }
}
