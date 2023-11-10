package com.cxy.level2.cxylevel2.service;

import com.cxy.level2.cxylevel2.dao.mapper.DeptMapper;
import com.cxy.level2.cxylevel2.dto.DeptDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.entity.Dept;
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
public class DeptService {

    private final DeptMapper deptMapper;

    public DeptService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public PageInfo<Dept> list(QueryPage<DeptDto> queryPage) {
        //select  .... limit (pageNum-1)*pageSize,pageSize
        PageHelper.startPage(queryPage.getPageNum(),queryPage.getPageSize());
        List<Dept> deptList = deptMapper.select(queryPage.getBody().toEntity());
        PageInfo<Dept> deptPageInfo = new PageInfo<>(deptList);
        return deptPageInfo;
    }

    public List<Dept> all() {
        return deptMapper.selectAll();
    }

    public int addOrUpdate(DeptDto deptDto) {
        if (deptDto.hasAdd())
            return  deptMapper.insert(deptDto.toEntity());
        else
            return deptMapper.update(deptDto.toEntity());
    }

    public int removeByIds(String ids) {
        return deptMapper.deleteByIds(ids);
    }
}
