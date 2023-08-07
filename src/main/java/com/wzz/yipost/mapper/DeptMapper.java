package com.wzz.yipost.mapper;

import com.wzz.yipost.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, createTime, updateTime) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
