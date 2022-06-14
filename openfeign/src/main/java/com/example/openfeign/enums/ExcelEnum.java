package com.example.openfeign.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Cui
 */
@Getter
public enum ExcelEnum {
    /**
     * StatisticsPatrolExcel Configuration enum
     */
    FILENAME( "用户信息.xls"),
    SHEETNAME( "用户信息报表"),
    FONTNAME("微软雅黑"),
    PATHNAME( "pathName"),
    PATH("path"),
    CONTENTTYPE("application/ms-excel;charset=UTF-8"),
    ADDHEADERNAME("Content-Disposition"),
    ADDHEADERVALUE("attachment;filename="),
    CHARACTERENCODING("UTF-8");

    private String text;

    ExcelEnum(String text) {
        this.text = text;
    }

    /**
     * StatisticsPatrolExcel Title
     */
    @Getter
    public enum ExcelTitleEnum {
        SERIALNUMBER( "序号"),
        USERNAME("用户姓名"),
        CITYNAME("城市名称"),
        AREANAME( "区域名称");

        private String text;

        ExcelTitleEnum(String text) {
            this.text = text;
        }
    }
    public static String[] getExcelCloum() {
        List<String> excelCloumList = new ArrayList<>();
        for (ExcelTitleEnum tEnum : ExcelTitleEnum.values()) {
                excelCloumList.add(tEnum.getText());
        }
        return excelCloumList.toArray(new String[excelCloumList.size()]);
    }
}
