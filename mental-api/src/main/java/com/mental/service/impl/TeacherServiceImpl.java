package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mental.dao.TeacherDao;
import com.mental.pojo.Teacher;
import com.mental.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教师
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    /**
     * 登录
     *
     * @param teacher
     * @return
     */
    @Override
    public Teacher login(Teacher teacher) {
        LambdaQueryWrapper<Teacher> query = new LambdaQueryWrapper<Teacher>();
        query.eq(teacher.getUsername() != null, Teacher::getUsername, teacher.getUsername());
        query.eq(teacher.getPassword() != null, Teacher::getPassword, teacher.getPassword());
        teacher = teacherDao.selectOne(query);

        return teacher;
    }
}
