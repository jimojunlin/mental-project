package com.mental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.QuestionBankDao;
import com.mental.pojo.QuestionBank;
import com.mental.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题库
 */
@Service
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankDao, QuestionBank> implements QuestionBankService {
    @Autowired
    private QuestionBankDao questionBankDao;

    /**
     * 获取所有题库
     *
     * @return
     */
    @Override
    public List<QuestionBank> getAll() {
        return questionBankDao.selectList(null);
    }
}
