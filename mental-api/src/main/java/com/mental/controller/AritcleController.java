package com.mental.controller;

import com.mental.common.Result;
import com.mental.dao.ArticleDao;
import com.mental.pojo.Article;
import com.mental.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科普文章
 */

@RestController
@RequestMapping("/article")
@Slf4j
public class AritcleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Article article){
        return articleService.add(article);
    }

    /**
     * 根据id获取信息
     */
    @GetMapping("{id}")
    public Result selectById(@PathVariable Integer id){
        return articleService.selectById(id);
    }

    /**
     * 获取所有信息
     */
    @GetMapping("/all")
    public Result selectAll(){
        return articleService.selectAll();
    }

    /**
     * 根据id删除对应文章
     */
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id){
        return articleService.deleteById(id);
    }

    /**
     * 修改文章启用状态
     */
    @PostMapping("/status/{id}")
    public Result updateStatusById(@PathVariable Integer id){
        return articleService.updateStatusById(id);
    }
}
