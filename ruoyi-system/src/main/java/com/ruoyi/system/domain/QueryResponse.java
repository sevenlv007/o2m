package com.ruoyi.system.domain;

import lombok.Data;
import org.springframework.util.DigestUtils;

/**
 * Created by fengfeng on 2020/9/21.
 */
@Data
public class QueryResponse extends ResBase {


    private String coupon_code;

    private String effective_tm;

    private String expire_tm;

    private String coupon_st;

    private String coupon_style="0";

    public void makeSign() {
        StringBuffer sb = new StringBuffer();
        sb.append("coupon_code=").append(this.coupon_code);
        sb.append("&coupon_id=").append(this.coupon_id);
        sb.append("&coupon_st=").append(this.coupon_st);
        sb.append("&coupon_style=").append(this.coupon_style);
        sb.append("&effective_tm=").append(this.effective_tm);
        sb.append("&encoding=").append(this.encoding);
        sb.append("&expire_tm=").append(this.expire_tm);
        sb.append("&rsp_code=").append(this.rsp_code);
        sb.append("&rsp_msg=").append(this.rsp_msg);
        sb.append("&svc_id=").append(this.svc_id);
        sb.append("&svc_trans_id=").append(this.svc_trans_id);
        sb.append("&txn_type=").append(this.txn_type);
        sb.append("&version=").append(this.version);
        sb.append("&key=").append(this.key);
        System.out.println(sb.toString());
        this.sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();

    }
}
