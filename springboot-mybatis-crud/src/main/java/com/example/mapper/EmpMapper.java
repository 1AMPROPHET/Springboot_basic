package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true) // 会自动生成主键值，赋值给emp对象的id属性
    @Insert("insert into emp(username, name, gender, image, job, entryDate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, " +
            "entryDate = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

//    @Select("select id, username, password, name, gender, image, job, entryDate, dept_id deptId, " +
//            "create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and entryDate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 使用concat拼接条件查询
    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and entryDate between #{begin} and #{end} order by update_time desc")
    public List<Emp> listConcat(String name, short gender, LocalDate begin, LocalDate end);

    // 使用XML映射文件
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

//    动态更新员工
    public void dynamicUpdate(Emp emp);

//    批量删除员工
    public void deleteByIds(List<Integer> ids);
}
