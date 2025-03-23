package com.itheima.springbootwebreqresp.controller;

import com.itheima.springbootwebreqresp.pojo.Address;
import com.itheima.springbootwebreqresp.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("Hello World");
//        return "Hello World";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address address = new Address();
//        address.setProvince("广东");
//        address.setCity("深圳");
//        return address;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        List<Address> list = new ArrayList<>();
//        Address address = new Address();
//        address.setProvince("广东");
//        address.setCity("深圳");
//
//        Address address1 = new Address();
//        address1.setProvince("陕西");
//        address1.setCity("西安");
//
//        list.add(address);
//        list.add(address1);
//
//        return list;
//    }
    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("Hello World");
//        return new Result(1, "success", "Hello World");
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address();
        address.setProvince("广东");
        address.setCity("深圳");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();
        Address address = new Address();
        address.setProvince("广东");
        address.setCity("深圳");

        Address address1 = new Address();
        address1.setProvince("陕西");
        address1.setCity("西安");

        list.add(address);
        list.add(address1);

        return Result.success(list);
    }
}
