package com.itheima.springbootwebreqresp.service.impl;

import com.itheima.springbootwebreqresp.dao.EmpDao;
import com.itheima.springbootwebreqresp.pojo.Emp;
import com.itheima.springbootwebreqresp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpServiceB implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        return null;
    }
}
