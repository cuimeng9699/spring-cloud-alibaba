package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.OperationSqlConfigMapper;
import com.example.openfeign.dao.mapper.extend.UserExtMapper;
import com.example.openfeign.dao.po.OperationSqlConfig;
import com.example.openfeign.service.CommonsService;
import com.share.foreign.enums.systemEnums.ErrorCode;
import com.share.foreign.exception.BaseException;
import com.share.foreign.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName CommonsServiceImpl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/26/22 10:12 PM
 */
@Service
@Slf4j
public class CommonsServiceImpl implements CommonsService {

    @Resource
    private UserExtMapper userExtMapper;
    @Resource
    private OperationSqlConfigMapper operationSqlConfigMapper;
    @Override
    public List<Map> queryCommons(Map map) {
        // 这里是准备参数去查询库里面具体的配置信息 id必传
        if (Objects.isNull(map.get("id"))) {
            log.error("id 参数为空 id {}",map.get("id")+"");
            throw new BaseException(ErrorCode.MISS_PARAM_ERROR);
        }
        String idStr = (String) map.get("id");
        if (!NumberUtil.isNumber(idStr)) {
            log.error("id 参数不是数字id {}",map.get("id")+"");
            throw new BaseException(ErrorCode.PARAM_ERROR);
        }
        Long id = Long.valueOf(idStr);
        OperationSqlConfig operationSqlConfig = operationSqlConfigMapper.selectByPrimaryKey(id);
        // 获取到配置信息进行校验是否是easy sql
        if (Objects.isNull(operationSqlConfig)) {
            log.error("未获取相关配置信息");
            throw new BaseException(ErrorCode.NOT_FOUND);
        }
        List<Map> resultList = new ArrayList<>();
        StringBuilder enterSqlAppend = new StringBuilder();
        if (!operationSqlConfig.getIsEasySql()) {
            enterSqlAppend
                    .append(operationSqlConfig.getOperationType())
                    .append(" ")
                    .append(operationSqlConfig.getFieldName())
                    .append(" ")
                    .append("from ")
                    .append(operationSqlConfig.getOperationTable())
                    .append(" ")
                    .append("where ");
        } else {
            String sql = operationSqlConfig.getFieldName();
            // 这里是当入参如果小于2 那么入参是只有id
            if (map.size() < 2){
                enterSqlAppend.append(" ").append(sql).append(operationSqlConfig.getOrderGroup());
                resultList = userExtMapper.getSql(String.valueOf(enterSqlAppend));
                return resultList;
            }
            enterSqlAppend.append(sql).append(" where ");
        }
        int num = 0;
        for (Object term : map.keySet()) {
            if (String.valueOf(term).equals("id")) {
                continue;
            }
            String[] termArr = operationSqlConfig.getTerm().split(",");
            for (String s : termArr) {
                if (String.valueOf(term).equals(s.replaceAll(" = ", ""))) {
                    if (num != 0) {
                        enterSqlAppend.append("and ");
                    }
                    enterSqlAppend.append(s).append("'").append(map.get(term)).append("'").append(" ");
                    num++;
                }
                if (String.valueOf(term).equals(s.replaceAll(" like", ""))) {
                    if (num != 0) {
                        enterSqlAppend.append("and ");
                    }
                    enterSqlAppend.append(s).append("'%").append(map.get(term)).append("%'").append(" ");
                    num++;
                }
            }
        }
        enterSqlAppend.append(operationSqlConfig.getOrderGroup());
        String enterSql = String.valueOf(enterSqlAppend);
        if (num == 0){
            enterSql = enterSql.replaceAll("where","");
        }
        resultList = userExtMapper.getSql(enterSql);
        return resultList;
    }
}
