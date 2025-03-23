package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete() {
        int id = empMapper.delete(18);
        System.out.println(id);
    }

    // 插入
    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("wangyuanfeng");
        emp.setName("王");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
    }

    // 更新
    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update(emp);

    }

    // 通过id查询
    @Test
    public void testSearch() {
        Emp emp = empMapper.getById(20);
        System.out.println(emp);
    }

    // 条件查询员工
    @Test
    public void testList() {
//        empMapper.list("张", (short)1, LocalDate.of(2000, 1, 1), LocalDate.of(2020, 10, 10));
        empMapper.list("张", (short)1, null, null);
    }

    @Test
    public void testListConcat() {
        empMapper.listConcat("张", (short)1, LocalDate.of(2000, 1, 1), LocalDate.of(2020, 10, 10));
//        empMapper.listConcat("张", (short)1, null, null);
    }

//    测试动态更新
    @Test
    public void testDynamicUpdate() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setGender((short)1);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.dynamicUpdate(emp);
    }

    @Test
    public void testBatchDelete() {
        List<Integer> list = Arrays.asList(19, 20);
        empMapper.deleteByIds(list);
    }

}
