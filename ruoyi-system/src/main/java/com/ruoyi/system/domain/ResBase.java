package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by fengfeng on 2020/9/21.
 */
@Data
public class ResBase extends ReqBase {

    protected String rsp_code="00";

    protected String rsp_msg = "SUCCESS";

    protected String svc_id ;

    protected String svc_trans_id;

    @JsonIgnore
    protected String key;
}
