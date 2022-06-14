package com.example.servicenacos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 下单
     * @return
     */
    @RequestMapping("/add")
    public String addOrder(){
        System.out.println("订单新增成功");
        RestTemplate restTemplate = new RestTemplate();
        //调用库存扣减
        String apiReqResult = restTemplate.getForObject("http://192.168.100.106:8030/stock/subStock",String.class);
        return "订单服务-订单新增成功:" + apiReqResult;
    }
}