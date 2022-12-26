package com.mental.service;

import com.mental.pojo.Teacher;

/**
 * 教师
 */
public interface TeacherService {
    /**
     * 登录
     * @param teacher
     * @return
     */
    Teacher login(Teacher teacher);
}
