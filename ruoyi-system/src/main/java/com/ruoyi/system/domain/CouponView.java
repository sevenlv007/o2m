package com.ruoyi.system.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fengfeng on 2020/10/21.
 */
@Data
public class CouponView implements Serializable{
    private String 优惠码;
    private String 订单号码;
    private String 开始时间;
    private String 截止时间;
    private String 优惠码状态;
    private String 订单时间;
    private String 优惠ID;

}
