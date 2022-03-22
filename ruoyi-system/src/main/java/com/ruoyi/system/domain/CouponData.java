package com.ruoyi.system.domain;

import lombok.Data;

/**
 * 数据库对象
 * Created by fengfeng on 2020/9/18.
 */
/*@Data

*/

@Data
public class CouponData extends CouponInfo {

    private int id ;

    private String svc_trans_id;

    private String order_no;

    private String txn_time;

    private int state;

    private String coupon_id;

    private String gift_mall_no;
}
