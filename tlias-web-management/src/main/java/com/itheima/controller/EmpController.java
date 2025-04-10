package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 条件查询操作
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询: {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除操作
     */
    @DeleteMapping("/{ids}")
    @Log
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除员工: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     */
    @PostMapping
    @Log
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 修改员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据Id查询员工信息， id： {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
