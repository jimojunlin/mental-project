package com.mental.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 题库
 */
@Data
@TableName("tb_question_bank")
public class QuestionBank {
    private Long id; //id
    private String title; //标题
    private String details; //详情
    private Integer number; //人数
    private Integer status; //状态 0启用，1禁用
    private String picture; // 图片
    private String picturebox; // 方图片
    private String pictureinfo; // 图片信息

    public QuestionBank() {
    }

    public QuestionBank(String title, String details) {
        this.title = title;
        this.details = details;
    }
}
