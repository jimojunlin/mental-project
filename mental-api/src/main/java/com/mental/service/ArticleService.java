package com.mental.service;

import com.mental.common.Result;
import com.mental.pojo.Article;

/**
 * 科普文章
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    Result add(Article article);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Result selectById(Integer id);

    /**
     * 查询所有
     * @return
     */
    Result selectAll();

    /**
     * 根据id删除对应文章
     * @param id
     * @return
     */
    Result deleteById(Integer id);

    /**
     * 根据id修改文章启用状态
     * @param id
     * @return
     */
    Result updateStatusById(Integer id);
}
