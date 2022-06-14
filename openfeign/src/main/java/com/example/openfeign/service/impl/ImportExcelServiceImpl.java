package com.example.openfeign.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.example.openfeign.dao.mapper.extend.UserExtendExtMapper;
import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.dao.po.UserExtendExample;
import com.example.openfeign.service.ImportExcelService;
import com.example.openfeign.utils.ImportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ImportExcelServiceImpl
 * @Description excel导入
 * @Author Mr.Cui
 * @Date 6/9/22 7:56 PM
 */
@Slf4j
@Service
public class ImportExcelServiceImpl implements ImportExcelService {

    @Resource
    private UserExtendExtMapper userExtendExtMapper;

    @Override
    public List<Long> importUserContext(InputStream inputStreams) throws Exception {

        Workbook workbook = null;
        // 把byte数组转换成流 再转换成file文件 取出workbook 这里是用集群分布式处理方式
        // InputStream inputStream = new ByteArrayInputStream(bytes);
        // MultipartFile file = new MockMultipartFile(ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        workbook = new HSSFWorkbook(new POIFSFileSystem(inputStreams));
        if (workbook == null) {
            log.info("导入---------workbook---------为null了!");
        }
        // 仅获取第一个sheet页的数据
        // 获取一个sheet也就是一个工作簿
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        Date date = new Date();
        List<UserExtend> insertList = new ArrayList<>();
        List<Long> idList = new ArrayList<>();
        for (int j = 1; j <= lastRowNum; j++) {
            Row row = sheet.getRow(j);
            if (row == null) {
                row = sheet.createRow(j);
            }
            // 获取excel中的用户id
            String excleUserId = ImportExcelUtils.getCellFormatValue(row.getCell(0)).toString().replaceAll(" +", "");
            // 获取excel中的用户姓名
            String excleUserName = ImportExcelUtils.getCellFormatValue(row.getCell(1)).toString().replaceAll(" +", "");
            // 获取excel中的城市id
            String excleCityId = ImportExcelUtils.getCellFormatValue(row.getCell(2)).toString().replaceAll(" +", "");
            // 获取excel中的城市姓名
            String excleCityName = ImportExcelUtils.getCellFormatValue(row.getCell(3)).toString().replaceAll(" +", "");
            // 获取excel中的区域id
            String excleAreaId = ImportExcelUtils.getCellFormatValue(row.getCell(4)).toString().replaceAll(" +", "");
            // 获取excel中的区域姓名
            String excleAreaName = ImportExcelUtils.getCellFormatValue(row.getCell(5)).toString().replaceAll(" +", "");
            // 跳过空白行
            if (StringUtils.isEmpty(excleUserId) && StringUtils.isEmpty(excleUserName) && StringUtils.isEmpty(excleCityId)
                    && StringUtils.isEmpty(excleCityName) && StringUtils.isEmpty(excleAreaId) && StringUtils.isEmpty(excleAreaName)) {
                continue;
            }
            UserExtend userExtend = UserExtend.builder()
                    .userId(Long.valueOf(excleUserId))
                    .userName(excleUserName)
                    .cityId(Integer.valueOf(excleCityId))
                    .cityName(excleCityName)
                    .areaId(Integer.valueOf(excleAreaId))
                    .areaName(excleAreaName)
                    .createTime(date)
                    .updateTime(date)
                    .isDeleted(false)
                    .build();
            insertList.add(userExtend);
            idList.add(userExtend.getUserId());
        }
        int count = userExtendExtMapper.batchInsert(insertList);
        return idList;
    }

    @Override
    public List<UserExtend> queryUserContext(List<Long> idList) {
        UserExtendExample userExtendExample = new UserExtendExample();
        UserExtendExample.Criteria criteria = userExtendExample.createCriteria();
        criteria.andUserIdIn(idList);
        List<UserExtend> userExtendList = userExtendExtMapper.selectByExample(userExtendExample);
        return userExtendList;
    }
}
