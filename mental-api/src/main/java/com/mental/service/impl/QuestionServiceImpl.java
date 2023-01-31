package com.mental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.QuestionDao;
import com.mental.pojo.Question;
import com.mental.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {
    @Autowired
    private QuestionDao quizDao;

    @Override
    public List<Question> selectAll(){

        return quizDao.selectList(null);
    }
}
