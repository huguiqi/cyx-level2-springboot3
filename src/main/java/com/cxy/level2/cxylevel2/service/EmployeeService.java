package com.cxy.level2.cxylevel2.service;

import com.cxy.level2.cxylevel2.dao.mapper.EmployeeMapper;
import com.cxy.level2.cxylevel2.dao.mapper.RaiseSalaryApplyMapper;
import com.cxy.level2.cxylevel2.dto.EmployeeDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.dto.RaiseSalaryApplyDto;
import com.cxy.level2.cxylevel2.entity.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    private final RaiseSalaryApplyMapper raiseSalaryApplyMapper;

    public EmployeeService(EmployeeMapper employeeMapper, RaiseSalaryApplyMapper raiseSalaryApplyMapper) {
        this.employeeMapper = employeeMapper;
        this.raiseSalaryApplyMapper = raiseSalaryApplyMapper;
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

    public int saveRaiseSalaryApply(RaiseSalaryApplyDto raiseSalaryApplyDto) {
        int flag = 0;
        try {

             Employee employee = new Employee();
             employee.setId(raiseSalaryApplyDto.getEmpId());
             employee.setSalary(raiseSalaryApplyDto.getSalary());
            flag = employeeMapper.updateSalary(employee);

             raiseSalaryApplyMapper.insert(raiseSalaryApplyDto.toEntity());
        } catch (Exception e) {
            log.error("报错信息如下:",e);
        }
        return flag;
    }
}
