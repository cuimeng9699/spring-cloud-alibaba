package com.example.openfeign.utils;

import com.share.foreign.exception.BaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * excel导入功能
 * @author houdandan
 *
 */
public class ImportExcelUtils {
	public static final Logger logger = LogManager.getLogger(ImportExcelUtils.class);
	// 读取excel
	public static Workbook readExcel(String filePath) {
		Workbook wb = null;
		if (filePath == null) {
			return null;
		}
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		
		//版本判断
		try {
			 is = new FileInputStream(filePath);
			 if(".xls".equals(extString)){
				 return wb = new HSSFWorkbook(is);
			 }else if(".xlsx".equals(extString)){
				 return wb = new XSSFWorkbook(is);
			 }else{
				 return wb = null;
		        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	/***
	 * @Title: checkExcel
	 * @Description: 判断表格格式
	 * @Author: cuimeng 2020/7/28  17:58
	 * @Param: [file]
	 */
	public static Workbook checkExcel(MultipartFile file) throws Exception {
		InputStream is =  null;
		try {
			is = file.getInputStream();
			// 获取文件名称
			String name = file.getOriginalFilename();
			// 从 . 开始读取到最后一位 如果是XLS返回HSSFWorkbook 如果是XLSX返回XSSFWorkbook
			if ("xls".equals(name.substring(name.indexOf("."), name.length()))) {
				return new HSSFWorkbook(new POIFSFileSystem(is));
			} else if ("xlsx".equals(name.substring(name.indexOf("."), name.length()))) {
				return new XSSFWorkbook(is);
			}
			throw new BaseException("模板格式有误，请检查");
		} catch (BaseException e) {
			throw new BaseException(e.getMessage());
		} catch (Exception e) {
			logger.error("ExcelUtil: 操作失败，原因为： "+e.getMessage(),e);
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// 获取单元格格式值
	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 判断cell类型
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				// 判断cell是否为日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					// 转换为日期格式YYYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 数字
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}

}
