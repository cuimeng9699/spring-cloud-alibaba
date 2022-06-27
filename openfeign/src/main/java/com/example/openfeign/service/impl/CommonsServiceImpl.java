package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.OperationSqlConfigMapper;
import com.example.openfeign.dao.mapper.extend.UserExtMapper;
import com.example.openfeign.dao.po.OperationSqlConfig;
import com.example.openfeign.service.ICommonsService;
import com.share.foreign.enums.systemEnums.ErrorCode;
import com.share.foreign.exception.BaseException;
import com.share.foreign.utils.CharacterUtils;
import com.share.foreign.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/** @ClassName CommonsServiceImpl @Description 公共接口 @Author Mr.Cui @Date 6/26/22 10:12 PM */
@Service
@Slf4j
public class CommonsServiceImpl implements ICommonsService {

  @Resource private UserExtMapper userExtMapper;
  @Resource private OperationSqlConfigMapper operationSqlConfigMapper;

  @Override
  public Map queryCommons(Map map) {
    OperationSqlConfig operationSqlConfig = checkParam(map);
    Integer offset = 0;
    Integer limit = 0;
    if (operationSqlConfig.getIsPage()) {
      if (StringUtils.isBlank(String.valueOf(map.get("pageSize")))
          || StringUtils.isBlank(String.valueOf(map.get("pageNum")))) {
        log.error("缺少参数 pageSize {},pageNum {}", map.get("pageSize") + "", map.get("pageNum") + "");
        throw new BaseException(ErrorCode.MISS_PARAM_ERROR);
      }
      Integer pageSize = Integer.valueOf(String.valueOf(map.get("pageSize")));
      Integer pageNum = Integer.valueOf(String.valueOf(map.get("pageNum")));
      offset = (pageNum - 1) * pageSize;
      limit = pageSize;
    }
    Map resultMap = new HashMap();
    List<Map> resultList = new ArrayList<>();
    StringBuilder enterSqlAppend = new StringBuilder();
    String sql = operationSqlConfig.getFieldName();
    enterSqlAppend.append(sql).append(" where ");
    int num = 0;
    for (Object term : map.keySet()) {
      if (String.valueOf(term).equals("id")) {
        continue;
      }
      String[] termArr = operationSqlConfig.getTerm().split(",");
      if (ArrayUtils.isNotEmpty(termArr)) {
        for (String s : termArr) {
          String termToStr = String.valueOf(term);
          boolean isNotBlank = StringUtils.isNotBlank(String.valueOf(map.get(term)));
          boolean equals = termToStr.equals(s.replaceAll(" = ", ""));
          boolean big = termToStr.equals(s.replaceAll(" > ", ""));
          boolean min = termToStr.equals(s.replaceAll(" < ", ""));
          if ((equals || big || min) && isNotBlank) {
            if (num != 0) {
              enterSqlAppend.append("and ");
            }
            enterSqlAppend.append(s).append("'").append(map.get(term)).append("'").append(" ");
            num++;
          }
          if (termToStr.equals(s.replaceAll(" like", "")) && isNotBlank) {
            if (num != 0) {
              enterSqlAppend.append("and ");
            }
            enterSqlAppend.append(s).append("'%").append(map.get(term)).append("%'").append(" ");
            num++;
          }
        }
      }
    }
    enterSqlAppend.append(operationSqlConfig.getOrderGroup());
    // 如果分页那么执行分页逻辑
    if (operationSqlConfig.getIsPage()) {
      String countSql =
          "select count(*) as totalCount "
              + CharacterUtils.getStrLastIndex(String.valueOf(enterSqlAppend), "from");
      Map totalCountMap = userExtMapper.getSql(countSql).get(0);
      Map pageMap = new LinkedHashMap();
      pageMap.put("pageSize", map.get("pageSize"));
      pageMap.put("pageNum", map.get("pageNum"));
      pageMap.putAll(totalCountMap);
      enterSqlAppend.append(" limit ").append(offset).append(",").append(limit);
      resultMap.put("page", pageMap);
    }
    String enterSql = String.valueOf(enterSqlAppend);
    if (num == 0) {
      enterSql = enterSql.replaceAll("where", "");
    }
    log.info("最终执行的sql:{}", enterSql);
    resultList = userExtMapper.getSql(enterSql);
    resultMap.put("list", resultList);
    return resultMap;
  }

  /**
   * @Description: 参数校验
   * @Date: 6/27/22 2:57 PM
   * @Author: Mr.Cui
   * @param [map]
   * @return: OperationSqlConfig
   **/
  private OperationSqlConfig checkParam(Map map) {
    // 这里是准备参数去查询库里面具体的配置信息 id必传
    if (Objects.isNull(map.get("id"))) {
      log.error("id 参数为空 id {}", map.get("id") + "");
      throw new BaseException(ErrorCode.MISS_PARAM_ERROR);
    }
    String idStr = (String) map.get("id");
    if (!NumberUtil.isNumber(idStr)) {
      log.error("id 参数不是数字id {}", map.get("id") + "");
      throw new BaseException(ErrorCode.PARAM_ERROR);
    }
    Long id = Long.valueOf(idStr);
    OperationSqlConfig operationSqlConfig = operationSqlConfigMapper.selectByPrimaryKey(id);
    // 获取到配置信息进行校验是否是easy sql
    if (Objects.isNull(operationSqlConfig)) {
      log.error("未获取相关配置信息");
      throw new BaseException(ErrorCode.NOT_FOUND);
    }
    return operationSqlConfig;
  }
}
