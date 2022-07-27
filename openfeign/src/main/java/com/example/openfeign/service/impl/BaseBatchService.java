package com.example.openfeign.service.impl;

import com.example.openfeign.service.BatchService;
import com.share.foreign.utils.LocalThreadPoolExecutor;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName BaseBatchService
 * @Description TODO
 * @Author Mr.Cui
 * @Date 7/27/22 3:18 PM
 */
public abstract class BaseBatchService implements BatchService {
    @Override
    public final Boolean batch() {
    CompletableFuture<Boolean> task =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return true;
              } catch (Exception e) {
                return false;
              }
            },
            LocalThreadPoolExecutor.getThreadPoolExecutor()).
                thenApply(r -> {
                    try{
                        return true;
                    }catch (Exception e){
                        return false;
                    }
                }
        );
        return task.join();
    }
}
