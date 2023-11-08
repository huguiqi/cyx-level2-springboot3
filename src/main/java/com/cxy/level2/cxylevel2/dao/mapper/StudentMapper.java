package com.cxy.level2.cxylevel2.dao.mapper;

import com.cxy.level2.cxylevel2.dto.StudentDto;
import com.cxy.level2.cxylevel2.entity.Student;
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
public interface StudentMapper {

    @Select("<script>" +
            "select * from student where id=#{id} " +
            "<if test=\"name != null and name != '' \"> or `name` like '%${name}%' </if>  " +
            "<if test=\"sex != null and sex != '' \"> or `sex` = #{sex} </if>" +
            "</script>")
    List<Student> select(Student student);


    @Select("select * from student")
    List<Student> selectAll();


    @Insert("insert into student(name,sex,birth,photo_url) values(#{name},#{sex},#{birth},#{photoUrl})")
    int insert(Student student);

    @Delete("delete from student where id=#{id}")
    void deleteById(Long id);

    @Update("update student set name=#{name}, sex=#{sex}, birth=#{birth}, photo_url=#{photoUrl} where id=#{id}")
    int update(StudentDto studentDto);
}
