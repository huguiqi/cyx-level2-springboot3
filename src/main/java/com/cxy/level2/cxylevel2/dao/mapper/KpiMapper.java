package com.cxy.level2.cxylevel2.dao.mapper;

import com.cxy.level2.cxylevel2.entity.EmployeeKPI;
import com.cxy.level2.cxylevel2.entity.Kpi;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/13/15:11
 * @summary:
 */

@Mapper
public interface KpiMapper {

    @Select("<script> " +
            "select emp.*, IFNULL(kpi.kpi,'未考核') as kpi,kpi.id kpiId, kpi.comments from employee emp " +
            "left join  " +
            "employee_kpi kpi on emp.id = kpi.employee_id " +
            "<where> " +
            "<if test=\"id !=null and id !=''\"> and emp.id like concat('%',#{id},'%') </if>" +
            "<if test=\"name !=null and name !=''\"> and emp.name like concat('%',#{name},'%') </if>" +
            "<if test=\"kpi !=null and kpi !=''\"> and kpi.kpi like concat('%',#{kpi},'%') </if>" +
            "</where> " +
            "</script>")
    List<EmployeeKPI> select(EmployeeKPI entity);

    @Update("update employee_kpi set leader = #{leader},kpi=#{kpi},comments=#{comments} where id=#{id}")
    int update(Kpi toEntity);

    @Insert("insert into employee_kpi(id, employee_id,leader,kpi,comments) values(#{id}, #{employeeId},#{leader},#{kpi},#{comments})")
    int insert(Kpi toEntity);
}
