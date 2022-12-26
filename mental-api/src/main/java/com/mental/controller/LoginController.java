package com.mental.controller;

import com.mental.common.Result;
import com.mental.pojo.Admin;
import com.mental.pojo.ResultCode;
import com.mental.pojo.Student;
import com.mental.pojo.Teacher;
import com.mental.service.AdminService;
import com.mental.service.StudentService;
import com.mental.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    /**
     * 学生登陆
     * @return
     */
    @PostMapping("/student")
    public Result studentLogin(@RequestBody Student student){
        try {
            Student stu = studentService.login(student);
            if(stu == null){
                return new Result(ResultCode.ERROR);
            }
        } catch (Exception e) {
            return new Result(ResultCode.ERROR);
        }

        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 教师登陆
     * @return
     */
    @PostMapping("/teacher")
    public Result teacherLogin(@RequestBody Teacher teacher){
        try {
            teacher = teacherService.login(teacher);
            if(teacher == null){
                return new Result(ResultCode.ERROR);
            }
        } catch (Exception e) {
            return new Result(ResultCode.ERROR);
        }

        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 管理员登陆
     * @return
     */
    @PostMapping("/admin")
    public Result teacherLogin(@RequestBody Admin admin){
        try {
            admin = adminService.login(admin);
            if(admin == null){
                return new Result(ResultCode.ERROR);
            }
        } catch (Exception e) {
            return new Result(ResultCode.ERROR);
        }

        return new Result(ResultCode.SUCCESS);
    }
}
