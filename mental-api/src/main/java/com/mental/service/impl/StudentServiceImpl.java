package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mental.dao.StudentDao;
import com.mental.pojo.PageQuery;
import com.mental.pojo.Student;
import com.mental.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        queryWrapper.like(pageQuery.getSid() != null, Student::getSid, pageQuery.getSid())
                .eq(pageQuery.getGender() != null && pageQuery.getGender().length()>0, Student::getGender, pageQuery.getGender())
                .eq(pageQuery.getAge() != null, Student::getAge, pageQuery.getAge());

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

    /**
     * 根据学号查询学生信息
     *
     * @param sid
     * @return
     */
    @Override
    public Student selectBySid(Long sid) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<Student>();
        queryWrapper.eq(sid != null, Student::getSid, sid);

        Student student = studentDao.selectOne(queryWrapper);

        return student;
    }

    /**
     * 修改学生信息
     *
     * @param student
     */
    @Override
    public void update(Student student) {
        studentDao.updateById(student);
    }
}
