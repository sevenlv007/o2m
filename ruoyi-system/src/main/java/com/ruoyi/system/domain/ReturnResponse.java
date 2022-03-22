package com.ruoyi.system.domain;

import lombok.Data;
import org.springframework.util.DigestUtils;

/**
 * Created by fengfeng on 2020/9/21.
 */

@Data
public class ReturnResponse extends ResBase {

    private String coupon_code;

    protected String order_no;


    protected String txn_time;

    public void makeSign() {
        StringBuffer sb = new StringBuffer();
        sb.append("coupon_code=").append(this.coupon_code);
        sb.append("&coupon_id=").append(this.coupon_id);
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
