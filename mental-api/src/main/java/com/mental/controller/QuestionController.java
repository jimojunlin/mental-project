package com.mental.controller;

import com.mental.service.AnswerService;
import com.mental.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService anwserService;

    /**
     * 根据题库id获取问题
     */

}
