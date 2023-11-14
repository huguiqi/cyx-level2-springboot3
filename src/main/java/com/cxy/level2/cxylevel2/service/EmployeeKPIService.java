package com.cxy.level2.cxylevel2.service;

import com.cxy.level2.cxylevel2.dao.mapper.KpiMapper;
import com.cxy.level2.cxylevel2.dto.EmployeeKpiDto;
import com.cxy.level2.cxylevel2.dto.KpiDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.entity.Employee;
import com.cxy.level2.cxylevel2.entity.EmployeeKPI;
import com.cxy.level2.cxylevel2.entity.Kpi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/14/10:54
 * @summary:
 */
@Service
public class EmployeeKPIService {

    private final KpiMapper kpiMapper;

    public EmployeeKPIService(KpiMapper kpiMapper) {
        this.kpiMapper = kpiMapper;
    }

    public PageInfo<EmployeeKPI> list(QueryPage<EmployeeKpiDto> queryPage) {
        PageHelper.startPage(queryPage.getPageNum(),queryPage.getPageSize());
        List<EmployeeKPI> deptList = kpiMapper.select(queryPage.getBody().toEntity());
        PageInfo<EmployeeKPI> deptPageInfo = new PageInfo<>(deptList);
        return deptPageInfo;
    }

    public int save(KpiDto kpiDto) {
        int flag = 0;
        if (StringUtils.hasText(kpiDto.getId())){
            flag = kpiMapper.update(kpiDto.toEntity());
        }else {
            String genId = String.valueOf(System.currentTimeMillis());
            Kpi toEntity = kpiDto.toEntity();
            toEntity.setId(genId);
            flag = kpiMapper.insert(toEntity);
        }
        return flag;

    }
}
