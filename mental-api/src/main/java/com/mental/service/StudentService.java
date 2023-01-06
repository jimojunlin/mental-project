package com.mental.service;

import com.mental.pojo.PageQuery;
import com.mental.pojo.Student;

import java.util.Map;

/**
 * 学生
 */
public interface StudentService {
    /**
     * 登录
     * @param student
     * @return
     */
    Student login(Student student);

    /**
     * 添加学生
     * @param student
     */
    void add(Student student);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    Map<String,Object> pageQuery(PageQuery pageQuery);
}
