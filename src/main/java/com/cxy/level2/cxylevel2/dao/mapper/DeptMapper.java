package com.cxy.level2.cxylevel2.dao.mapper;

import com.cxy.level2.cxylevel2.entity.Dept;
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
public interface DeptMapper {

    @Select("<script>" +
            "select * from dept " +
            "<where>  " +
            "<if test=\"id != null and id != '' \"> and id like concat('%',#{id},'%') </if>" +
            "<if test=\"manager != null and manager != '' \"> and `manager` like concat('%',#{manager},'%') </if>  " +
            "<if test=\"name != null and name != '' \"> and `name` like concat('%', #{name} ,'%')  </if>" +
            "</where>"+
            "</script>")
    List<Dept> select(Dept dept);


    @Select("select * from dept")
    List<Dept> selectAll();


    @Insert("insert into dept(id,manager,name) values(#{id},#{manager},#{name})")
    int insert(Dept dept);

    @Delete("delete from dept where id in(${ids})")
    int deleteByIds(String ids);

    @Update("update dept set name=#{name}, manager=#{manager} where id=#{id}")
    int update(Dept dept);
}
