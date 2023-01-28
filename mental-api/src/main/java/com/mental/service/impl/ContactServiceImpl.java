package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.ContactDao;
import com.mental.pojo.AnwserAndQuiz;
import com.mental.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl extends ServiceImpl<ContactDao, AnwserAndQuiz> implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<AnwserAndQuiz> select(Long id) {
        LambdaQueryWrapper<AnwserAndQuiz> lqw = new LambdaQueryWrapper<AnwserAndQuiz>();
        lqw.eq(AnwserAndQuiz::getQuizId, id);

        List<AnwserAndQuiz> list = contactDao.selectList(lqw);

        return list;
    }
}
