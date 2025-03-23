package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect6 {
    @Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.deleteById(java.lang.Integer))")
    private void pt() {};

//    @Pointcut("execution(* com.itheima.service.DeptService.list()) || execution(* com.itheima.service.DeptService.deleteById(java.lang.Integer))")
//    private void pt1() {};

    @Before("pt()")
    public void before() {
        log.info("MyAspect6... before ...");
    }

//    @Around("pt1()")
//    public void around() {
//        log.info("around before...");
//        log.info("around after...");
//    }
}
