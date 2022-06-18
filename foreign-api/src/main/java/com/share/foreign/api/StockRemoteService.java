package com.share.foreign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient(name = "${remote.service.consumer.name}", contextId = "stock")
public interface StockRemoteService {

    //声明需要调用的rest接口对应的方法
    /**
     * 库存扣减
     * @return
     */
    @RequestMapping("/stock/subStock")
    @ResponseBody
    String subStock();

    /**
     * 库存新增
     *
     *
     * @return
     */
    @RequestMapping("/stock/addStock")
    @ResponseBody
    String addStock();
}
