package com.ruoyi.system.domain;


import lombok.Data;

/**
 * 返回数据
 * Created by fengfeng on 2020/9/18.
 */


@Data
public class CouponInfo {

    private String coupon_code;

    private String effective_tm;

    private String expire_tm;

    public String fatchSign(){
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"coupon_code\":\"").append(this.coupon_code).append("\"");
        sb.append(",\"effective_tm\":\"").append(this.effective_tm).append("\"");
        sb.append(",\"expire_tm\":\"").append(this.expire_tm).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
