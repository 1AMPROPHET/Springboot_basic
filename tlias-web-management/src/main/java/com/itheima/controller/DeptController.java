package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts") // 公共路径
public class DeptController {
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping("/depts")

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id) {
        log.info("删除指定部门");
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询员工：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
