package com.mental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.QuestionBankDao;
import com.mental.pojo.QuestionBank;
import com.mental.service.QuestionBankService;
import org.springframework.stereotype.Service;

/**
 * 题库
 */
@Service
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankDao, QuestionBank> implements QuestionBankService {
}
