package com.mental.service.impl;

import com.mental.common.Result;
import com.mental.common.ResultCode;
import com.mental.dao.ArticleDao;
import com.mental.pojo.Article;
import com.mental.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @Override
    public Result add(Article article) {
        articleDao.insert(article);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @Override
    public Result selectById(Integer id) {
        Article article = articleDao.selectById(id);
        return new Result(ResultCode.SUCCESS, article);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public Result selectAll() {
        List<Article> articles = articleDao.selectAll();
        return new Result(ResultCode.SUCCESS, articles);
    }

    /**
     * 根据id删除对应文章
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteById(Integer id) {
        articleDao.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id修改文章启用状态
     *
     * @param id
     * @return
     */
    @Override
    public Result updateStatusById(Integer id) {
        //查询当前文章状态
        Article article = articleDao.selectStatusById(id);

        //修改文章状态
        article.setStatus(article.getStatus() == 1 ? 0 : 1);
        articleDao.updateById(article);

        return new Result(ResultCode.SUCCESS);
    }
}
