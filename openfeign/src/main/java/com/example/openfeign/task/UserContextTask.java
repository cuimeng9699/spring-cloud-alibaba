package com.example.openfeign.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserContextTask
 * @Description 用户信息数据定时任务
 * @Author Mr.Cui
 * @Date 6/10/22 5:25 PM
 */
@Component
@Slf4j
public class UserContextTask {

    /**
     * @Description: 定时任务
     * @Date: 6/10/22 5:37 PM
     * @Author: Mr.Cui
     * @return: void
     **/
    @Scheduled(cron = "0 */1 * * * ?")
    @Async
    public void userContextTask(){
        System.out.println("=============过了一分钟===========");
    }
}
