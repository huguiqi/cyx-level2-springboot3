package com.cxy.level2.cxylevel2.controller;

import com.cxy.level2.cxylevel2.dto.DeptDto;
import com.cxy.level2.cxylevel2.dto.QueryPage;
import com.cxy.level2.cxylevel2.entity.Dept;
import com.cxy.level2.cxylevel2.service.DeptService;
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
@RequestMapping("dept")
@CrossOrigin
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<Dept> list(@RequestBody QueryPage<DeptDto> queryPage){
            return deptService.list(queryPage);
    }

    @GetMapping(value ="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dept> dept(){
        return deptService.all();
    }

    @PostMapping(value ="/save")
    public int dept(@RequestBody DeptDto deptDto){
        return deptService.addOrUpdate(deptDto);
    }


    @DeleteMapping(value ="/removes")
    public int dept(@RequestParam("ids") String ids){
        return deptService.removeByIds(ids);
    }

}
