package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mental.dao.TeacherDao;
import com.mental.pojo.PageQuery;
import com.mental.pojo.Teacher;
import com.mental.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 添加教师
     *
     * @param teacher
     */
    @Override
    public void add(Teacher teacher) {
        teacherDao.insert(teacher);
    }

    /**
     * 分页查询
     *
     * @param pageQuery
     * @return
     */
    @Override
    public Map<String, Object> pageQuery(PageQuery pageQuery) {
        Page<Teacher> page = new Page<Teacher>(pageQuery.getCurrentPage(), pageQuery.getPageSize());

        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<Teacher>();
        queryWrapper.like(pageQuery.getQuery() != null, Teacher::getTid, pageQuery.getQuery())
                .or().like(pageQuery.getQuery() != null, Teacher::getAge, pageQuery.getQuery())
                .or().like(pageQuery.getQuery() != null, Teacher::getGender, pageQuery.getQuery());

        teacherDao.selectPage(page, queryWrapper);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("currentPage",pageQuery.getCurrentPage());
        map.put("pageSize", pageQuery.getPageSize());
        map.put("data",page.getRecords());

        return map;
    }

    /**
     * 根据工号删除教师信息
     *
     * @param tid
     */
    @Override
    public void deleteByTid(Long tid) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<Teacher>();
        queryWrapper.eq(tid != null, Teacher::getTid, tid);

        teacherDao.delete(queryWrapper);
    }

    /**
     * 根据工号查询教师信息
     *
     * @param tid
     * @return
     */
    @Override
    public Teacher selectByTid(Long tid) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<Teacher>();
        queryWrapper.eq(tid != null, Teacher::getTid, tid);

        Teacher teacher = teacherDao.selectOne(queryWrapper);

        return teacher;
    }

    /**
     * 修改教师信息
     *
     * @param teacher
     */
    @Override
    public void updateByTid(Teacher teacher) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<Teacher>();
        queryWrapper.eq(teacher.getTid() != null, Teacher::getTid, teacher.getTid());

        teacherDao.update(teacher, queryWrapper);
    }
}
