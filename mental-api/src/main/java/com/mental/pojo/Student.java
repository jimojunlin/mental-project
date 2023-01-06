package com.mental.pojo;

import lombok.Data;

/**
 * 学生类
 */
@Data
public class Student{
    //id
    private Long id;
    //学号
    private Long sid;
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
    private String grade;
    //学院
    private String college;
    //学校
    private String school;
    //地址
    private String address;
    //头像
    private String avatar;
    //个性签名
    private String signature;

}
