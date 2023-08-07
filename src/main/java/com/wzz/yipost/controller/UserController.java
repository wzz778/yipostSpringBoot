package com.wzz.yipost.controller;

import com.wzz.yipost.pojo.PageBean;
import com.wzz.yipost.pojo.Result;
import com.wzz.yipost.pojo.User;
import com.wzz.yipost.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j//日志log的注解
@RequestMapping("/users")
@RestController
@CrossOrigin
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping("/search")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "3") Integer pageSize,
                       String name,
                        Short gender,
                       Short deptId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
                       ){
        log.info("分页查询，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end,deptId);
        PageBean pageBean = userService.page(page,pageSize,name,gender,begin,end,deptId);
        return Result.success(pageBean);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/deletes/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除，参数ids：{}",ids);
        userService.delete(ids);
        return Result.success();
    }

    /**
     * 增加员工
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        log.info("增加员工，参数user：{}",user);
        userService.save(user);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/getUserById")
    public Result getById(@RequestParam(defaultValue = "1") Integer id){
        log.info("根据用户id查询员工，参数id：{}",id);
        User user= userService.getById(id);
        return Result.success(user);
    }

    /**
     * 根据id删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUserById")
    public Result deleteUserById(@RequestParam(defaultValue = "1") Integer id){
        log.info("根据用户id删除员工，参数id：{}",id);
        User user= userService.deleteUserById(id);
        return Result.success(user);
    }

    /**
     * 更新员工信息
     * @param user
     * @return
     */
    @PutMapping("/upload")
    public Result update(@RequestBody User user){
        log.info("更新员工信息 : {}", user);
        userService.update(user);
        return Result.success();
    }
}
