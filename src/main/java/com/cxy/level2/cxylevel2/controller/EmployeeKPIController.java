package com.cxy.level2.cxylevel2.controller;

import com.cxy.level2.cxylevel2.dto.EmployeeDto;
import com.cxy.level2.cxylevel2.dto.EmployeeKpiDto;
import com.cxy.level2.cxylevel2.dto.KpiDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.entity.Employee;
import com.cxy.level2.cxylevel2.entity.EmployeeKPI;
import com.cxy.level2.cxylevel2.service.EmployeeKPIService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/14/10:52
 * @summary:
 */
@RestController
@RequestMapping("kpi")
@CrossOrigin
public class EmployeeKPIController {

    private final EmployeeKPIService employeeKPIService;

    public EmployeeKPIController(EmployeeKPIService employeeKPIService) {
        this.employeeKPIService = employeeKPIService;
    }


    @PostMapping(value = "/list")
    public PageInfo<EmployeeKPI> list(@RequestBody QueryPage<EmployeeKpiDto> queryPage){
        return this.employeeKPIService.list(queryPage);
    }


    @PostMapping(value ="/checkSave")
    public int checkSave(@RequestBody KpiDto kpiDto){
        return employeeKPIService.save(kpiDto);
    }

}
