package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> list = empMapper.page(start, pageSize);
//        return new PageBean(count, list);
//    }

    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate start, LocalDate end) {
        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, start, end);
        Page<Emp> p = (Page<Emp>) empList;
        // 3. 封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    public void  delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.inert(emp);
    }

    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
