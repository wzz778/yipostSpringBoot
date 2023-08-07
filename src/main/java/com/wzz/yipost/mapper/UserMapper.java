package com.wzz.yipost.mapper;

import com.wzz.yipost.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from user")
    public Long count();

    /**
     *查询
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @param deptId
     * @return
     */
    public List<User> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin,@Param("end") LocalDate end,@Param("deptId") Short deptId);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    @Insert("insert into user(username, name, gender, image, job, entrydate, deptId, createTime, updateTime) " +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(User user);

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    void update(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);

    @Select("delete from user where id=#{id}")
    User deleteById(Integer id);
}
