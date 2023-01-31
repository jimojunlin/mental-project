package com.mental.controller;

import com.mental.common.Result;
import com.mental.common.ResultCode;
import com.mental.pojo.QuestionBank;
import com.mental.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 题库
 */
@RestController
@RequestMapping("/questionBank")
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 获取所有题库
     */
    @GetMapping("/all")
    public Result getAll(){
        try {
            List<QuestionBank> bankList = questionBankService.getAll();
            return new Result(ResultCode.SUCCESS, bankList);
        } catch (Exception e){
            e.printStackTrace();
            return new Result(ResultCode.ERROR);
        }

    }

}
