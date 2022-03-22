package com.ruoyi.system.domain;


import java.io.Serializable;
import java.util.List;
import lombok.Data;


/**
 * Created by fengfeng on 2020/10/19.
 */


 @Data
public class CouponManagerResponse extends LoginResponse implements Serializable {
    private List<CouponView> datas;
}
