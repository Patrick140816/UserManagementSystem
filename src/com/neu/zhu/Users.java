package com.neu.zhu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Users {
    // 用户名
    private String name;
    // 密码
    private int password;
    // 邮箱
    private String email;
    // 权限
    private String authority;
}
