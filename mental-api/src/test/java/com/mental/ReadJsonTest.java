package com.mental;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mental.pojo.Anwser;
import com.mental.pojo.AnwserAndQuiz;
import com.mental.pojo.Quiz;
import com.mental.service.AnwserService;
import com.mental.service.ContactService;
import com.mental.service.QuizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest()
public class ReadJsonTest {
    @Autowired
    private QuizService quizService;

    @Autowired
    private AnwserService anwserService;

    @Autowired
    private ContactService contactService;

    @Test
    void readJson() throws Exception {
        File file = new File("C:\\Users\\Lonely\\Desktop\\SCL-90.json");

        //读取文件中json数据
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map> list = objectMapper.readValue(file, List.class);

        for (Map map : list) {
            /**
             * 设置问题
             */
            Quiz quiz = new Quiz();
//            quiz.setId(Long.parseLong(map.get("id").toString()));
            quiz.setQuestionIndex((Integer) map.get("question_index"));
            quiz.setTitle((String) map.get("title"));
            System.out.println(quiz);
            quizService.save(quiz);
            Long quizId = quiz.getId();

            /**
             * 设置答案
             */
            Map anwsers = (Map) map.get("anwsers");
            Set<String> set = anwsers.keySet();
            for (String str : set) {
                Map m = (Map) anwsers.get(str);
                Anwser anwser = new Anwser();
                anwser.setAnswer(m.get("anwser").toString());
                anwser.setAnwserScore(Integer.parseInt(m.get("anwser_score").toString()));
                System.out.println(anwser);
                anwserService.save(anwser);
                Long anwserId = anwser.getId();

                //设置关系表
                AnwserAndQuiz anwserAndQuiz = new AnwserAndQuiz(quizId, anwserId);
                contactService.save(anwserAndQuiz);
            }
        }
    }

    @Test
    void getData() throws Exception {
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

        System.out.println(quizzes);
    }
}
