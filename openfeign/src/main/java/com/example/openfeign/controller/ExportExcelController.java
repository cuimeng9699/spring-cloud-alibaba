package com.example.openfeign.controller;

import com.share.foreign.enums.ExcelEnum;
import com.share.foreign.enums.systemEnums.ErrorCode;
import com.example.openfeign.service.IExportExcelService;
import com.share.foreign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExportExcelController
 * @Description excel导出
 * @Author Mr.Cui
 * @Date 6/9/22 10:30 AM
 */
@RestController
@RequestMapping("/export")
@Slf4j
public class ExportExcelController {

    @Resource
    private IExportExcelService exportExcelService;

    @GetMapping("/exportUserContext")
    public ResponseTemplate exportUserContext(Long id, String userName, String cityName, String startTime, String endTime,
                                              HttpServletResponse response) {
        ResponseTemplate responseTemplate = null;
        try {
            Map<String, Object> returnMap = new HashMap<>();
            returnMap = exportExcelService.exportUserContext(id, userName, cityName, startTime, endTime);
            String path = (String) returnMap.get(ExcelEnum.PATH.getText());
            String pathName = (String) returnMap.get(ExcelEnum.PATHNAME.getText());
            response.setContentType(ExcelEnum.CONTENTTYPE.getText());
            response.setHeader(ExcelEnum.ADDHEADERNAME.getText(), ExcelEnum.ADDHEADERVALUE.getText()
                    .concat(String.valueOf(URLEncoder.encode(pathName, ExcelEnum.CHARACTERENCODING.getText()))));
            File file = new File(path);
            response.getOutputStream();
            fileUpload(new FileInputStream(file), response.getOutputStream());
            File delFile = new File(path);
            delFile.delete();
        } catch (Exception e) {
            log.error(" Exception :{}", e);
            return ResponseTemplate.buildFailResult(ErrorCode.FAILED_REQUEST);
        }
        return responseTemplate;
    }

    private void fileUpload(InputStream is, OutputStream os) throws Exception {
        byte[] b = new byte[1024 * 1024 * 10];
        int len = 0;
        while (true) {
            len = is.read(b);
            if (len < 0) {
                break;
            }
            os.write(b, 0, len);
        }
        is.close();
        os.close();
    }
}
