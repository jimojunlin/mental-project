package com.mental.service;

import com.mental.pojo.Admin;

/**
 * 管理员
 */
public interface AdminService {
    Admin login(Admin admin);

    /**
     * 根据id获取管理员信息
     * @param id
     * @return
     */
    Admin selectById(Long id);

    /**
     * 修改管理员信息
     * @param admin
     */
    void update(Admin admin);
}
