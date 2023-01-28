package com.mental.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_quiz_anwser")
public class AnwserAndQuiz {
    private Long quizId;
    private Long anwserId;

    public AnwserAndQuiz() {
    }

    public AnwserAndQuiz(Long quizId, Long anwserId) {
        this.quizId = quizId;
        this.anwserId = anwserId;
    }
}
