package com.mental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mental.pojo.QuestionBank;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题库
 */
@Mapper
public interface QuestionBankDao extends BaseMapper<QuestionBank> {
}
