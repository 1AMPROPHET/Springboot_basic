package com.itheima.springbootwebreqresp.dao.impl;

import com.itheima.springbootwebreqresp.dao.EmpDao;
import com.itheima.springbootwebreqresp.pojo.Emp;
import com.itheima.springbootwebreqresp.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 将当前类交给IOC容器管理，成为容器中的Bean
//衍生注解
//@Service
//@Repository("daoA")
public class EmpDaoA implements EmpDao {
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
