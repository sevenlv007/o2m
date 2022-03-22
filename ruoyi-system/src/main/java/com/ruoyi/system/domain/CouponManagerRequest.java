package com.ruoyi.system.domain;


import java.io.Serializable;

import lombok.Data;
/**
 * Created by fengfeng on 2020/10/19.
 */

 @Data
public class CouponManagerRequest extends LoginRequest  implements Serializable {

    private String coupon_code;

    private Integer state;


    private String codes;

    private String coupon_id;
}
