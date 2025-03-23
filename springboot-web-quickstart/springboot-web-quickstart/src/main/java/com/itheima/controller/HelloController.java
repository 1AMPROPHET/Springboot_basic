package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类 注解 @RestController @RequestMapping
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello () {
        System.out.println("hello world");
        return "hello world";
    }
}
