package com.ruoyi.system.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by fengfeng on 2020/10/19.
 */
@Data

public class LoginResponse implements Serializable {

    private String comment;

    private int state;
}
