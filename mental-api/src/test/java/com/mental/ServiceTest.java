package com.mental;

import com.mental.pojo.QuestionBank;
import com.mental.service.QuestionBankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 获取所有题库信息
     */
    @Test
    void getAllByQuestionBank(){
        List<QuestionBank> all = questionBankService.getAll();
        System.out.println(all);
    }
}
