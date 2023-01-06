package com.mental.pojo;

import lombok.Data;

/**
 * 分页查询条件
 */
@Data
public class PageQuery {
    //当前页
    private int currentPage;
    //每页条数
    private int pageSize;
    //查询条件
    private String query;
}
