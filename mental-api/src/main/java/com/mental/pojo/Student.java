package com.mental.pojo;

import lombok.Data;

/**
 * 学生类
 */
@Data
public class Student{
    //id
    private int id;
    //学号
    private int sid;
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
    //年级
    private int grade;
    //地址
    private String address;
    //头像
    private String avatar;
    //个性签名
    private String signature;

}
