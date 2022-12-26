package com.mental.controller;

import com.mental.common.Result;
import com.mental.pojo.ResultCode;
import com.mental.pojo.Student;
import com.mental.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private StudentService studentService;

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
}
