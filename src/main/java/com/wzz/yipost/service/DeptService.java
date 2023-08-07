package com.wzz.yipost.service;

import com.wzz.yipost.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门信息
     * @return
     */
    List<Dept> list();
    /**
     * 删除部门信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);
}
