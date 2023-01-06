package com.mental.pojo;

import lombok.Data;

/**
 * 教师类
 */
@Data
public class Teacher {
    //id
    private int id;
    //工号
    private int tid;
    //账号
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private int age;
    //性别
    private String gender;
    //职称
    private int title;
    //部门
    private String department;
    //学校
    private String school;
    //头像
    private String avatar;
    //个性签名
    private String signature;
}
