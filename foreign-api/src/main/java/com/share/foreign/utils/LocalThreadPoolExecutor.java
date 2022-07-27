package com.share.foreign.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** @ClassName LocalThreadPoolExecutor @Description TODO @Author Mr.Cui @Date 7/27/22 3:40 PM */
public class LocalThreadPoolExecutor {

  public static ExecutorService getThreadPoolExecutor() {
    return LocalThreadPoolFactory.FIXED_THREAD_POOL;
  }

  private static class LocalThreadPoolFactory {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService FIXED_THREAD_POOL =
        new ThreadPoolExecutor(
            2, CPU_COUNT + 1, 20L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
  }
}
