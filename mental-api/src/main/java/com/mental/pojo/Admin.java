package com.mental.pojo;

import lombok.Data;

/**
 * 管理员类
 */
@Data
public class Admin {
    //id
    private Long id;
    //账号
    private String username;
    //密码
    private String password;
    //邮箱
    private String email;
    //角色
    private String role;
    //头像
    private String avatar;
}
