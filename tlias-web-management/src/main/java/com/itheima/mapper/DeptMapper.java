package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set update_time = #{updateTime}, name = #{name} where id = #{id}")
    void update(Dept dept);
}
