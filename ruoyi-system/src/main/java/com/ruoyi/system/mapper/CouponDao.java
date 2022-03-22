package com.ruoyi.system.mapper;


 import com.ruoyi.system.domain.CouponData;
 import com.ruoyi.system.domain.CouponInfo;
 import com.ruoyi.system.domain.CouponManagerRequest;
 import com.ruoyi.system.domain.CouponRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by fengfeng on 2020/9/18.
 */
@Mapper
public interface CouponDao {
    /**
     *  private String coupon_code;

     private String svc_trans_id;

     private String effective_tm;


     private String order_no;

     private String txn_time;

     private int state;
     private String expire_tm;
     * @param data
     * @return
     */
    @Select("select * from dm_coupon where order_no=#{order_no} and coupon_id=#{coupon_id}")
    List<CouponData> findByOrder(CouponData data);

    @Select("select * from dm_coupon where state =0 and coupon_id =#{coupon_id} limit #{buy_qty}")
    List<CouponData> findNew(CouponRequest req); //找到一个状态为未使用的coupon 


    @Update("update dm_coupon set expire_tm=#{expire_tm},effective_tm=#{effective_tm},order_no=#{order_no},txn_time=#{txn_time},gift_mall_no=#{gift_mall_no},svc_trans_id=#{svc_trans_id},state=#{state} where id=#{id}")
    void updateCoupon(CouponData data); 

    @Select("select * from dm_coupon where (#{coupon_id} is null or coupon_id=#{coupon_id}) and coupon_code=#{coupon_code}")
    CouponData queryByCode(CouponRequest req); //根据code查询

    @Select("select * from dm_coupon where 1=1 and (#{coupon_id} is null or coupon_id =#{coupon_id}) and (#{coupon_code} ='' or coupon_code =#{coupon_code}) and  (#{state} is null or state=#{state})")
    List<CouponData> queryList(CouponManagerRequest request);  //查询？

    @Update("update dm_coupon set state = #{state} where coupon_code= #{coupon_code}")
    void updateState(CouponData data); //按状态编辑数据
    
    @Insert("insert into dm_coupon(coupon_id,coupon_code) values(#{coupon_id},#{coupon_code})")
    void addCoupon(CouponData data); //添加coupon
}
