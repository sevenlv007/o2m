package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.DigestUtils;

/**
 * Created by fengfeng on 2020/9/30.
 */
@Data
public class NoticeRequest extends ReqBase {
    private int inv_flag;

    private int inv_cnt;

    private String svc_id;

    @JsonIgnore
    private String key;

    public  void makeSign(){
        StringBuffer sb = new StringBuffer();
        sb.append("coupon_id=").append(this.coupon_id);
        sb.append("&encoding=").append(this.encoding);
        sb.append("&inv_cnt=").append(this.inv_cnt);
        sb.append("&inv_flag=").append(this.inv_flag);
        sb.append("&svc_id=").append(this.svc_id);
        sb.append("&txn_type=").append(this.txn_type);
        sb.append("&version=").append(this.version);
        sb.append("&key=").append(this.key);
        System.out.println(sb.toString());
        this.sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        this.key = null;
    }
}
