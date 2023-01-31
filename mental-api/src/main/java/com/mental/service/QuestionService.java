package com.mental.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mental.pojo.Question;

import java.util.List;

/**
 * 问题
 */
public interface QuestionService extends IService<Question> {
    List<Question> selectAll();
}
