package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.extend.UserExtendExtMapper;
import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.service.IPageQueryService;
import com.share.foreign.utils.Page;
import com.share.foreign.utils.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName PageQueryServiceImpl
 * @Description 分页查询用户信息
 * @Author Mr.Cui
 * @Date 6/9/22 11:01 AM
 */
@Slf4j
@Service
public class PageQueryServiceImpl implements IPageQueryService {

    @Resource
    private UserExtendExtMapper userExtendExtMapper;

    @Override
    public PageResult<UserExtend> pageQueryUserContext(Long id, String userName, String cityName, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        Long count = 0L;
        // 查询用户表数量
        count = userExtendExtMapper.queryUserContextCount(id, userName, cityName, startTime, endTime);
        Integer offset = (pageNum - 1) * pageSize;
        Integer limit = pageSize;
        PageResult<UserExtend> pageResult = new PageResult<>();
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotalCount(count);
        pageResult.setPage(page);
        if (count < 1) {
            pageResult.setList(Collections.emptyList());
            return pageResult;
        }
        // 查询用户表中的数据
        List<UserExtend> userExtendList = userExtendExtMapper.pageQueryUserContext(id, userName, cityName, startTime, endTime, offset, limit);
        pageResult.setList(userExtendList);
        return pageResult;
    }
}
