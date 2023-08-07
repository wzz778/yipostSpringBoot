package com.wzz.yipost.controller;

import com.wzz.yipost.pojo.Dept;
import com.wzz.yipost.pojo.Result;
import com.wzz.yipost.service.DeptService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j//日志log的注解
@RequestMapping("/depts")
@RestController
@CrossOrigin
@Api(tags = "部门")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门
     * @return
     */
    @GetMapping("/search")
    public Result list(){
        log.info("查询全部部门的数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据ID删除部门
     * @return
     */

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Dept dept){
        log.info("部门：{新增部门：{}}",dept);
        deptService.add(dept);
        return Result.success();
    }//
}
