package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.DigestUtils;

/**
 * Created by fengfeng on 2020/9/21.
 */
@Data
public class UsedRequest extends ReqBase {

    protected String coupon_code;

    protected String svc_id;

    private String order_no;

    @JsonIgnore
    protected String key;

    protected String txn_time;

    protected  String verify_tm;

    public  void makeSign(){
        StringBuffer sb = new StringBuffer();
        sb.append("coupon_code=").append(this.coupon_code);
        sb.append("&coupon_id=").append(this.coupon_id);
        sb.append("&encoding=").append(this.encoding);
        sb.append("&order_no=").append(this.order_no);
        sb.append("&svc_id=").append(this.svc_id);
        sb.append("&txn_time=").append(this.txn_time);
        sb.append("&txn_type=").append(this.txn_type);
        sb.append("&verify_tm=").append(this.verify_tm);
        sb.append("&version=").append(this.version);
        sb.append("&key=").append(this.key);
        System.out.println(sb.toString());
        this.sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        this.key = null;
    }
}
