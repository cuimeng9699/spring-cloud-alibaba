package com.example.serviceconsumer.controller;

import com.share.foreign.api.StockRemoteService;
import org.springframework.stereotype.Controller;


/**
 * 库存服务
 */
@Controller
public class StockController implements StockRemoteService {

    /*@Value("${server.port}")
    private String port;*/

    /**
     * 库存新增
     * @return
     */
    @Override
    public String addStock(){
        System.out.println("库存新增成功");

        return "库存服务-库存新增成功";
    }

    /**
     * 库存扣减
     * @return
     */
    @Override
    public String subStock(){
        System.out.println("库存扣减成功");

        return "库存服务-库存扣减成功 -1";
    }
}
