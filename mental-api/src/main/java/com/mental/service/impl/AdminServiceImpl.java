package com.mental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mental.dao.AdminDao;
import com.mental.pojo.Admin;
import com.mental.pojo.Student;
import com.mental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        LambdaQueryWrapper<Admin> query = new LambdaQueryWrapper<Admin>();
        query.eq(admin.getUsername() != null, Admin::getUsername, admin.getUsername());
        query.eq(admin.getPassword() != null, Admin::getPassword, admin.getPassword());
        admin = adminDao.selectOne(query);

        return admin;
    }
}
