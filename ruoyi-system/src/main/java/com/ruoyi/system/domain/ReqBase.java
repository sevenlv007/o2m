package com.ruoyi.system.domain;

import lombok.Data;

/**
 * Created by fengfeng on 2020/9/18.
 */
@Data
public class ReqBase {

    protected String version = "1.0.0";

    protected String encoding ="UTF-8";

    protected String txn_type;


    protected String sign;

    protected String coupon_id;
}
