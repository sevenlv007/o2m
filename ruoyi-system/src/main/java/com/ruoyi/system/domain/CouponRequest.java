package com.ruoyi.system.domain;

import lombok.Data;

/**
 * Created by fengfeng on 2020/9/18.
 */

@Data
public class CouponRequest extends ReqBase {

    protected String txn_time;

    protected String order_no;

    private Integer buy_qty; //买几个

    private String user_id;

    private String gift_mall_no;

    private String coupon_code;

 
}
