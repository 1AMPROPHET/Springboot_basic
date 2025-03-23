package com.itheima.service;

import com.itheima.pojo.DeptLog;
import org.springframework.stereotype.Service;

@Service
public interface DeptLogService {
    void insert(DeptLog deptLog);
}
