package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.extend.UserExtendExtMapper;
import com.example.openfeign.dao.po.UserExtend;
import com.example.openfeign.service.IExportExcelService;
import com.share.foreign.dto.GroupDTO;
import com.share.foreign.enums.ExcelEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ExportExcelServiceImpl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/9/22 5:27 PM
 */
@Slf4j
@Service
public class ExportExcelServiceImpl implements IExportExcelService {
    @Resource
    private UserExtendExtMapper userExtendExtMapper;
    @Override
    public Map<String, Object> exportUserContext(Long id, String userName, String cityName, String startTime, String endTime) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        List<UserExtend> userExtendList = userExtendExtMapper.pageQueryUserContext(id, userName, cityName, startTime, endTime, null, null);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(ExcelEnum.SHEETNAME.getText());
        //设置默认列宽
        sheet.setDefaultColumnWidth(15);
        String[] sheetTitle = ExcelEnum.getExcelCloum();
        createTitle(workbook, sheet, sheetTitle);
        CellStyle style = workbook.createCellStyle();

        Font font = workbook.createFont();
        // 字体
        font.setFontName(ExcelEnum.FONTNAME.getText());
        style.setFont(font);
        int cellNum = 0;
        if (!CollectionUtils.isEmpty(userExtendList)){
            for (UserExtend userExtend : userExtendList) {
                HSSFRow row = sheet.createRow(cellNum + 1);
                // 序号
                row.createCell(0).setCellValue(cellNum + 1);
                // 用户姓名
                row.createCell(1).setCellValue(userExtend.getUserName());
                // 城市名称
                row.createCell(2).setCellValue(userExtend.getCityName());
                // 区域名称
                row.createCell(3).setCellValue(userExtend.getAreaName());
                cellNum++;
            }
        }
        String fileName = ExcelEnum.FILENAME.getText();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        log.info("directoryPath {}", com.getPath().toString());
        String deskExcelPath = com.getPath() + File.separator + fileName;
        log.info("directoryPath {}", deskExcelPath);
        FileOutputStream fout = new FileOutputStream(deskExcelPath);
        workbook.write(fout);
        fout.flush();
        fout.close();
        workbook.close();
        map.put(ExcelEnum.PATHNAME.getText(), fileName);
        map.put(ExcelEnum.PATH.getText(), deskExcelPath);
        return map;
    }

    /**
     * 创建表头
     *
     * @param workbook
     * @param sheet
     * @param titleList
     */
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] titleList) {
        HSSFRow row = sheet.createRow(0);
        // 设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        font.setFontName(ExcelEnum.FONTNAME.getText());
        style.setFont(font);
        HSSFCell cell;
        for (int i = 0; i < titleList.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleList[i]);
            cell.setCellStyle(style);
        }
    }

  public static void main(String[] args) {
      // 准备数据
      List<GroupDTO> userList = new ArrayList<GroupDTO>();
      for (int i = 0; i < 100; i++) {
          GroupDTO user = new GroupDTO(i,new BigDecimal(i+"."+i));
          userList.add(user);
      }
      Map<Long, List<GroupDTO>> collect = userList.parallelStream().collect(Collectors.groupingBy(GroupDTO::getId));
    for (Long aLong : collect.keySet()) {
      //
      System.out.println(aLong);
    }
// for version
      BigDecimal result1 = BigDecimal.ZERO;
      for (GroupDTO user : userList) {
          result1 = result1.add(user.getMoney());
      }
      System.out.println("result1 = "+result1);
      BigDecimal result2 = userList.stream()
              // 将user对象的mongey取出来map为Bigdecimal
              .map(GroupDTO::getMoney)
              // 使用reduce聚合函数,实现累加器
              .reduce(BigDecimal.ZERO,BigDecimal::add);
      System.out.println("result2 = "+result2);
      long count = userList.stream().count();
    System.out.println(count);
  }
}
