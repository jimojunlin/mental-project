package com.mental.controller;

import com.mental.common.Result;
import com.mental.pojo.ResultCode;
import com.mental.pojo.Teacher;
import com.mental.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getinfo")
public class GteInfoController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("{id}")
    public Result getInfoTeacher(@PathVariable int id){
        Teacher info = teacherService.getInfo(id);
        try {
            if(info == null){
                return new Result(ResultCode.ERROR);
            }
        }catch (Exception e){
            return new Result(ResultCode.ERROR);
        }
        return new Result(ResultCode.SUCCESS,info);
    }
}
