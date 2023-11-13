package com.cxy.level2.cxylevel2.dao.mapper;

import com.cxy.level2.cxylevel2.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/02/20:06
 * @summary:
 */
@Mapper
public interface EmployeeMapper {

    @Select("<script>" +
            "select * from employee " +
            "<where>  " +
            "<if test=\"id != null and id != '' \"> and id like concat('%',#{id},'%') </if>" +
            "<if test=\"dept != null and dept != '' \"> and `dept` like concat('%',#{dept},'%') </if>  " +
            "<if test=\"name != null and name != '' \"> and `name` like concat('%', #{name} ,'%')  </if>" +
            "<if test=\"position != null and position != '' \"> and `position` like concat('%', #{position} ,'%')  </if>" +
            "<if test=\"salary != null and salary != '' \"> and `salary` like concat('%', #{salary} ,'%')  </if>" +
            "</where>"+
            "</script>")
    List<Employee> select(Employee employee);


    @Select("select * from employee")
    List<Employee> selectAll();


    @Insert("insert into employee(id,name,dept,position,salary) values(#{id},#{name},#{dept},#{position},#{salary})")
    int insert(Employee employee);

    @Delete("delete from employee where id in(${ids})")
    int deleteByIds(String ids);

    @Update("update employee set name=#{name}, dept=#{dept}, position=#{position} where id=#{id}")
    int update(Employee employee);

    @Update("update employee set salary= salary + #{salary} where id=#{id}")
    int updateSalary(Employee employee);
}
