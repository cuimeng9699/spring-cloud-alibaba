package com.example.openfeign.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.openfeign.dao.po.UserExtend;
import com.share.foreign.enums.systemEnums.ErrorCode;
import com.example.openfeign.service.ImportExcelService;
import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ImportExcelController
 * @Description 导入excel
 * @Author Mr.Cui
 * @Date 6/9/22 10:48 AM
 */
@RestController
@RequestMapping("/import")
@Slf4j
public class ImportExcelController {

    @Resource
    private ImportExcelService importExcelService;

    /**
     * @param uploadFile
     * @param request
     * @Description: excel导入
     * @Date: 6/9/22 8:08 PM
     * @Author: Mr.Cui
     * @return: ResponseTemplate
     **/
    @PostMapping("/importUserContext")
    public ResponseTemplate<List<Long>> importUserContext(@RequestParam("file") MultipartFile uploadFile,
                                                          HttpServletRequest request) {
        List<Long> idList = new ArrayList<>();
        try {
            // 初始化导入excel文件名
            String fileName = "";
            // 获取上传excel文件名
            fileName = uploadFile.getOriginalFilename();
            // 判断文件名是否为空
            if (StringUtils.isEmpty(fileName)) {
                return ResponseTemplate.buildFailResult(ErrorCode.UPLOAD_NO_FILE);
            }
            // 导入文件类型校验
            if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
                return ResponseTemplate.buildFailResult(ErrorCode.UPLOAD_NO_FILE_FORMAT);
            }
            // 判断浏览器类型
            String systemName = request.getHeader("user-agent");
            int have = systemName.indexOf("Windows NT 10.0");
            if (have != -1) {
                // 非IE浏览器
                fileName = fileName.replace(" ", "");
                fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
            }
            // IE浏览器
            fileName = fileName.replace(" ", "");
            log.info("获取上传excel文件名为：" + fileName);
            // 将excel 文件转成byte数组
            // byte[] bytes = uploadFile.getBytes();
            InputStream inputStream = uploadFile.getInputStream();
            idList = importExcelService.importUserContext(inputStream);
        } catch (Exception e) {
            log.error("导入excel发生异常:{}",e);
            return ResponseTemplate.buildFailResult(ErrorCode.FAILED_REQUEST);
        }
        return ResponseTemplate.buildSuccessResult(idList);
    }

    /**
     * @Description: 导入的数据反查
     * @Date: 6/10/22 4:22 PM
     * @Author: Mr.Cui
     * @param idList 反查导入id集合
     * @return: ResponseTemplate<List<UserExtend>>
     **/
    @PostMapping("/queryUserContext")
    public ResponseTemplate<List<UserExtend>> queryUserContext(@RequestBody BaseDTO<List<Long>> idList) {
        List<UserExtend> userExtendList = importExcelService.queryUserContext(idList.getBody());
        return ResponseTemplate.buildSuccessResult(userExtendList);
    }
}
