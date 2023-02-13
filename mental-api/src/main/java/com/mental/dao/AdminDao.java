package com.mental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mental.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {
//    @Select("select id, username, email, avatar from admin where id = #{id}")
//    public Admin selectById(Long id);
}
