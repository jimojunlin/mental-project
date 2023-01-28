package com.mental.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mental.pojo.AnwserAndQuiz;

import java.util.List;

public interface ContactService extends IService<AnwserAndQuiz> {
    List<AnwserAndQuiz> select(Long id);
}
