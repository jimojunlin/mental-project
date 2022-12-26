package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mental.dao.StudentDao;
import com.mental.pojo.Student;
import com.mental.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 登录
     *
     * @param student
     * @return
     */
    @Override
    public Student login(Student student) {
        LambdaQueryWrapper<Student> query = new LambdaQueryWrapper<Student>();
        query.eq(student.getUsername() != null, Student::getUsername, student.getUsername());
        query.eq(student.getPassword() != null, Student::getPassword, student.getPassword());
        Student stu = studentDao.selectOne(query);

        return stu;
    }
}
