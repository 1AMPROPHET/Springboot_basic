package com.itheima.springbootwebreqresp.controller;
import com.itheima.springbootwebreqresp.pojo.Emp;
import com.itheima.springbootwebreqresp.pojo.Result;
import com.itheima.springbootwebreqresp.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

//    @Autowired // 运行时，IOC容器会提供该类型bean对象并赋值给对象，称为依赖注入
//    @Qualifier("empServiceA")
    @Resource(name="empServiceA")
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        //1. 加载并解析emp.xml
        List<Emp> empList = empService.listEmp();

        //3. 响应数据
        return Result.success(empList);
    }

}
