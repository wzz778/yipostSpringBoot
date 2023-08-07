package com.wzz.yipost.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzz.yipost.mapper.UserMapper;
import com.wzz.yipost.pojo.PageBean;
import com.wzz.yipost.pojo.User;
import com.wzz.yipost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name,Short gender, LocalDate begin, LocalDate end,Short deptId){
//        //1.获取总条数
//        Long conut= userMapper.count();
//        //2.获取分页查询的结果列表
//        Integer start= (page -1) * pageSize;
//        List<User> userList= userMapper.list(start,pageSize,name,gender,begin,end);
        //1.获取总条数
        PageHelper.startPage(page,pageSize);

        //2.获取分页查询的结果列表
        List<User> userList= userMapper.list(name, gender, begin, end,deptId);
        Page<User> p=(Page<User>) userList;
        //封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),(long)page,(long)pageSize, (long) p.getPages(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public void save(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());

        userMapper.update(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public User deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

}
