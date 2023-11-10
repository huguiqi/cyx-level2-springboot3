package com.cxy.level2.cxylevel2.service;

import com.cxy.level2.cxylevel2.dao.mapper.EmployeeMapper;
import com.cxy.level2.cxylevel2.dto.EmployeeDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.entity.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/02/20:04
 * @summary:
 */
@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public PageInfo<Employee> list(QueryPage<EmployeeDto> queryPage) {
        //select  .... limit (pageNum-1)*pageSize,pageSize
        PageHelper.startPage(queryPage.getPageNum(),queryPage.getPageSize());
        List<Employee> deptList = employeeMapper.select(queryPage.getBody().toEntity());
        PageInfo<Employee> deptPageInfo = new PageInfo<>(deptList);
        return deptPageInfo;
    }

    public List<Employee> all() {
        return employeeMapper.selectAll();
    }

    public int addOrUpdate(EmployeeDto employeeDto) {
        if (employeeDto.hasAdd())
            return  employeeMapper.insert(employeeDto.toEntity());
        else
            return employeeMapper.update(employeeDto.toEntity());
    }

    public int removeByIds(String ids) {
        return employeeMapper.deleteByIds(ids);
    }
}
