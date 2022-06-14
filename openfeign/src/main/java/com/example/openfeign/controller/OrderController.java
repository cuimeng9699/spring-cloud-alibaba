package com.example.openfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.openfeign.dao.po.User;
import com.example.openfeign.dto.UserDTO;
import com.example.openfeign.interfance.StockOpenFeignService;
import com.example.openfeign.service.TestService;
import com.example.openfeign.wrapper.BaseDTO;
import com.example.openfeign.wrapper.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private StockOpenFeignService stockOpenFeignService;
    @Resource(name ="testServiceImpl" )
    private TestService testService;
    @Value("#{'${ababa.myList}'.split(',')}")
    private List<String> myList;
    /**
     * 新增订单
     * @return
     */
    @GetMapping("/addOrder")
    public String addOrder(){
        for (String s : myList) {
            log.info(s);
        }
        //调用库存扣减
        String result = stockOpenFeignService.subStock();

        log.info("=============="+result);
        return "订单服务-库存扣减成功:" + result;
    }
    /**
     * test database
     * @return
     */
    @PostMapping(value = "/mapper",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate<User> mapper(@RequestBody BaseDTO<UserDTO> request){
        log.info("请求头数据信息为{}:", JSONObject.toJSONString(request));
        User user = testService.getUserById(request.getBody().getId());

        log.info("=============="+user);
        return ResponseTemplate.buildSuccessResult(user);
    }

}
