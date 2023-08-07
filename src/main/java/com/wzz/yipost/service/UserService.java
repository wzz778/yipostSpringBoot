package com.wzz.yipost.service;

import com.wzz.yipost.pojo.PageBean;
import com.wzz.yipost.pojo.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param deptId
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end, Short deptId);


    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param user
     */
    void save(User user);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 修改员工的信息
     * @param user
     */
    void update(User user);

    /**
     * 员工登录
     * @param user
     * @return
     */
    User login(User user);


    User deleteUserById(Integer id);
}
