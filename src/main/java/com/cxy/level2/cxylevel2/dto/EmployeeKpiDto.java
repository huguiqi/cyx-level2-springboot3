package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.Employee;
import com.cxy.level2.cxylevel2.entity.EmployeeKPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/14/10:55
 * @summary:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeKpiDto {


    private String id,name,dept,position;
    private float salary;
    private String kpi;


    public EmployeeKPI toEntity() {
        EmployeeKPI entity = new EmployeeKPI();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
