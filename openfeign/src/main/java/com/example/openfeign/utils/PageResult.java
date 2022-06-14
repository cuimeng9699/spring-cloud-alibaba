package com.example.openfeign.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PageResult
 *
 * @author Mr.Cui
 * @date 2020/04/08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult<T> {
    /**
     * 默认页码1
     */
    public static final int DEFAULT_PAGE_NUM = 1;
    /**
     * 默认页码大小10
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 页面类
     */
    private Page page;
    /**
     * 分页结果集合
     */
    private List<T> list;


    /***
     * 成功返回数据
     * @param page     分页的对象
     * @param dataList 返回的数据
     * @return
     */
    public static <T> PageResult<T> successData(Page page, List<T> dataList) {
        return new PageResult(page, dataList);
    }
}
