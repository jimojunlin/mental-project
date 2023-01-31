package com.mental.controller;

import com.mental.common.Result;
import com.mental.common.ResultCode;
import com.mental.pojo.QuestionBank;
import com.mental.service.QuestionBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 题库
 */
@RestController
@RequestMapping("/questionBank")
@Slf4j
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 获取所有题库
     */
    @GetMapping("/all")
    public Result getAll() {
        try {
            List<QuestionBank> bankList = questionBankService.getAll();
            return new Result(ResultCode.SUCCESS, bankList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.ERROR);
        }
    }

    /**
     * 修改题库状态
     */
    @PostMapping("/status")
    public Result updateStatusById(Long id) {
        log.info("修改题库状态：{}", id);
        try {
            questionBankService.updateStatusById(id);
            return new Result(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.ERROR);
        }
    }

    /**
     * 获取题库信息
     * @param id
     * @return
     */
    @GetMapping("/get")
    public Result selectById(Long id) {
        try {
            QuestionBank questionBank = questionBankService.getById(id);
            return new Result(ResultCode.SUCCESS, questionBank);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ResultCode.ERROR);
        }
    }

}
