package com.mental.controller;

import com.mental.common.Result;
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
    public Student studentLogin(@RequestBody Student student){
        Student student1 = studentService.login(student);

        return student1;
    }
}
