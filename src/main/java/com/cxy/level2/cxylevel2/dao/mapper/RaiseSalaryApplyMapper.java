package com.cxy.level2.cxylevel2.dao.mapper;

import com.cxy.level2.cxylevel2.entity.RaiseSalaryApply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface RaiseSalaryApplyMapper {

    @Insert("insert into raise_salary_apply(emp_id,emp_name,approver,position,dept,salary,approve_comment) values(#{empId},#{empName},#{approver},#{position},#{dept},#{salary},#{approveComment})")
     int insert(RaiseSalaryApply entity);
}
