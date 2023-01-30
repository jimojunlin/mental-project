package com.mental.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mental.pojo.Quiz;

import java.util.List;

public interface QuizService extends IService<Quiz> {
    List<Quiz> selectAll();
}
