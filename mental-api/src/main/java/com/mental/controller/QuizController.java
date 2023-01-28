package com.mental.controller;

import com.mental.common.Result;
import com.mental.common.ResultCode;
import com.mental.pojo.Anwser;
import com.mental.pojo.AnwserAndQuiz;
import com.mental.pojo.Quiz;
import com.mental.service.AnwserService;
import com.mental.service.ContactService;
import com.mental.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private AnwserService anwserService;

    @Autowired
    private ContactService contactService;

    @GetMapping("all")
    public Result selectAll(){
        List<Quiz> quizzes = quizService.selectAll();
        for (Quiz quiz : quizzes) {
            List<AnwserAndQuiz> select = contactService.select(quiz.getId());
            List<Anwser> anwsers = new ArrayList<Anwser>();
            for (AnwserAndQuiz anwserAndQuiz : select) {
                Long anwserId = anwserAndQuiz.getAnwserId();
                Anwser anwser = anwserService.getById(anwserId);
                anwsers.add(anwser);
            }
            quiz.setAnwsers(anwsers);
        }

        return new Result(ResultCode.SUCCESS, quizzes);
    }

}
