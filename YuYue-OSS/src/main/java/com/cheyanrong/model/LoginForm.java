package com.cheyanrong.model;

import lombok.Data;

import java.io.Serializable;

@Data

public class LoginForm implements Serializable {
    private String loginName;
    private String password;
}
