package com.mental.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 答案
 */
@Data
@TableName("tb_anwser")
public class Anwser {
    private Long id; //id
    private String answer; //答案
    private Integer anwserScore;  //答案得分
}
