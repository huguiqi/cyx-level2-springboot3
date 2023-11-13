package com.cxy.level2.cxylevel2.controller;

import com.cxy.level2.cxylevel2.dto.EmployeeDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.dto.RaiseSalaryApplyDto;
import com.cxy.level2.cxylevel2.entity.Employee;
import com.cxy.level2.cxylevel2.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/02/20:53
 * @summary:
 */
@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<Employee> list(@RequestBody QueryPage<EmployeeDto> queryPage){
            return employeeService.list(queryPage);
    }

    @GetMapping(value ="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> all(){
        return employeeService.all();
    }

    @PostMapping(value ="/save")
    public int dept(@RequestBody EmployeeDto deptDto){
        return employeeService.addOrUpdate(deptDto);
    }


    @DeleteMapping(value ="/removes")
    public int dept(@RequestParam("ids") String ids){
        return employeeService.removeByIds(ids);
    }


    @PostMapping(value ="/raiseSalaryApply")
    public int saveRaiseSalaryApply(@RequestBody RaiseSalaryApplyDto raiseSalaryApplyDto){
        return employeeService.saveRaiseSalaryApply(raiseSalaryApplyDto);
    }

}
