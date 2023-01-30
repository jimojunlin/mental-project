package com.mental.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * 问题表
 */
@Data
@TableName("tb_quiz")
public class Quiz {
    private Long id; //id
    private Integer questionIndex;  //问题索引
    private String title;  //标题
    @TableField(exist = false)
    private List<Anwser> anwsers; //答案
}
