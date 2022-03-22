package com.ruoyi.system.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fengfeng on 2020/10/19.
 */
@Data
public class LoginRequest implements Serializable {

    private String userName;

    private String password;

    private String sign;
}
