package com.wzz.yipost.controller;


import com.wzz.yipost.pojo.Result;
import com.wzz.yipost.pojo.User;
import com.wzz.yipost.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j//日志log的注解
@RestController
@CrossOrigin
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("员工登录:{}",user);
        User u= userService.login(user);
        return u!=null?Result.success():Result.error("用户名或密码错误！");
    }
}
