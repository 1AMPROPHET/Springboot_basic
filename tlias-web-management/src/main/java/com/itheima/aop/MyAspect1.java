package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect1 {
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pointCut() {};

    @Before("pointCut()")
    public void before () {
        log.info("before...");
    }

    @Around("pointCut()")
    public Object around (ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before...");

        // 调用目标方法执行
        Object result = joinPoint.proceed();

        log.info("around after...");
        return result;
    }

    @After("pointCut()")
    public void after () {
        log.info("after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning () {
        log.info("afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing () {
        log.info("afterThrowing...");
    }
}
