package com.mental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.AnswerDao;
import com.mental.pojo.Answer;
import com.mental.service.AnswerService;
import org.springframework.stereotype.Service;

/**
 * 答案
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, Answer> implements AnswerService {
}
