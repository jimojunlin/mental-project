package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mental.dao.StudentDao;
import com.mental.pojo.PageQuery;
import com.mental.pojo.Student;
import com.mental.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 学生
 */
@Service
@Transactional
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
        student = studentDao.selectOne(query);

        return student;
    }

    /**
     * 添加学生
     *
     * @param student
     */
    @Override
    public void add(Student student) {
        studentDao.insert(student);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public Map<String, Object> pageQuery(PageQuery pageQuery) {
        Page<Student> page = new Page<Student>(pageQuery.getCurrentPage(), pageQuery.getPageSize());

        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<Student>();
        queryWrapper.like(pageQuery.getQuery() != null, Student::getSid, pageQuery.getQuery())
                .or().like(pageQuery.getQuery() != null, Student::getGender, pageQuery.getQuery())
                .or().like(pageQuery.getQuery() != null, Student::getAge, pageQuery.getQuery());

        studentDao.selectPage(page, queryWrapper);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", page.getTotal());
        result.put("currentPage", pageQuery.getCurrentPage());
        result.put("pageSize", pageQuery.getPageSize());
        result.put("data", page.getRecords());

        return result;
    }

    /**
     * 根据学号删除学生信息
     *
     * @param sid
     */
    @Override
    public void deleteBySid(Long sid) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<Student>();
        queryWrapper.eq(sid != null, Student::getSid, sid);

        studentDao.delete(queryWrapper);
    }
}
