package com.itheima.springbootwebreqresp.service;

import com.itheima.springbootwebreqresp.pojo.Emp;

import java.util.List;

public interface EmpService {
    // 获取员工列表数据
    public List<Emp> listEmp();
}
