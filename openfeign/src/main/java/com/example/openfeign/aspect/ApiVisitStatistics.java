package com.example.openfeign.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** @ClassName ApiVisitStatistics @Description 接口切面 @Author Mr.Cui @Date 8/8/22 1:40 PM */
@Slf4j
@Component
@Aspect
public class ApiVisitStatistics {

  // 统计请求的处理时间,每个线程是独立的
  ThreadLocal<Long> startTime = new ThreadLocal<>();
  // 整个服务是唯一的
  public static final Map<String, Long> map = new ConcurrentHashMap<>();

  /** 定义切面 - 此处代表controller包下的所有接口都会被统计 */
  @Pointcut("execution(* com.example.openfeign.controller..*.*(..))")
  public void pointCut() {}

  /** 在接口原有的方法执行前，将会首先执行此处的代码 */
  @Before("pointCut()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    startTime.set(System.currentTimeMillis());
    // 获取传入目标方法的参数
    Object[] args = joinPoint.getArgs();
    String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    String key = className + "." + methodName;
    // 计数：如果不存在key，就设置为0，如果存在就在基础上加1
    map.computeIfAbsent(key, s -> 0L);
    map.computeIfPresent(key, (s, aLong) -> aLong + 1);

    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    // 记录请求的内容
    log.info("Call address:" + request.getRequestURL().toString());
    log.info("Call_Method:" + request.getMethod());
    log.info("Api访问次数：" + key + "=" + map.get(key));
  }

  /** 只有正常返回才会执行此方法 记录接口访问时长 */
  @AfterReturning(returning = "returnVal", pointcut = "pointCut()")
  public void doAfterReturning(JoinPoint joinPoint, Object returnVal) {
    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    log.info("方法执行时间:" + (System.currentTimeMillis() - startTime.get()));
    log.info("方法返回值:" + JSON.toJSONString(returnVal));
  }

  /** 当接口报错时执行此方法 */
  @AfterThrowing(pointcut = "pointCut()")
  public void doAfterThrowing(JoinPoint joinPoint) {
    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    log.info(
        "接口访问失败，URI:[{}], 耗费时间:[{}] ms",
        request.getRequestURI(),
        System.currentTimeMillis() - startTime.get());
  }
}
