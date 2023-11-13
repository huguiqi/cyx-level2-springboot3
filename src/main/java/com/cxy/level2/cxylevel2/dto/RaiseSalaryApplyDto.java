package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.RaiseSalaryApply;
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
 * @since: 2023/11/13/15:00
 * @summary:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaiseSalaryApplyDto {

//    {"id":"","name":"","dept":"","position":"","salary":"","approver":"审批人","approveComment":"审批意见"}

    private String empId, empName, dept,position,approver,approveComment;

    private float salary;


    public RaiseSalaryApply toEntity() {
        RaiseSalaryApply entity = new RaiseSalaryApply();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
