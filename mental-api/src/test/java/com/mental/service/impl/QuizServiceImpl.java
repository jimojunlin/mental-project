package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.QuizDao;
import com.mental.pojo.Quiz;
import com.mental.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl extends ServiceImpl<QuizDao, Quiz> implements QuizService {
    @Autowired
    private QuizDao quizDao;

    public List<Quiz> selectAll(){

        return quizDao.selectList(null);
    }
}
