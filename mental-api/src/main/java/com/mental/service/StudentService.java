package com.mental.service;

import com.mental.pojo.Student;

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
}
