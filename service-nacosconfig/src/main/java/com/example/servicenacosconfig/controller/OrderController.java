package com.example.servicenacosconfig.controller;

import com.example.servicenacosconfig.interfance.StockOpenFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/order")
@RefreshScope //配置此类接口动态刷新
public class OrderController {

    @Resource
    private StockOpenFeignService stockOpenFeignService;

    @Value("${user.name}")
    public String[] userName;
    @Value("${user.age}")
    public Integer age;
    @Value("${user.area}")
    public String area;
    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(){
        System.out.println("订单新增成功");
        //调用库存扣减
        String result = stockOpenFeignService.subStock();
        String returnContext = "";
        for (int i = 0; i < userName.length; i++) {
            returnContext = "订单服务-订单新增成功:" + result + " --userName：" + userName[i]+age+area;
        }
        return returnContext;
    }
}
