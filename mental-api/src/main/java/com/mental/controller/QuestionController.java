package com.mental.controller;

import com.mental.service.AnswerService;
import com.mental.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuestionController {
    @Autowired
    private QuestionService quizService;

    @Autowired
    private AnswerService anwserService;

//    @GetMapping("all")
//    public Result selectAll(){
//        List<Question> quizzes = quizService.selectAll();
//        for (Question quiz : quizzes) {
//            List<AnwserAndQuiz> select = contactService.select(quiz.getId());
//            List<Answer> anwsers = new ArrayList<Answer>();
//            for (AnwserAndQuiz anwserAndQuiz : select) {
//                Long anwserId = anwserAndQuiz.getAnwserId();
//                Answer anwser = anwserService.getById(anwserId);
//                anwsers.add(anwser);
//            }
//            quiz.setAnwsers(anwsers);
//        }
//
//        return new Result(ResultCode.SUCCESS, quizzes);
//    }

}
