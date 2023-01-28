package com.mental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mental.pojo.AnwserAndQuiz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactDao extends BaseMapper<AnwserAndQuiz> {
}
