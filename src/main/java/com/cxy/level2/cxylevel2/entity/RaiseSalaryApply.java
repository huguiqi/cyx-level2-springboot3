package com.cxy.level2.cxylevel2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/13/15:14
 * @summary:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaiseSalaryApply {

    private String empId, empName, dept,position,approver,approveComment;

    private float salary;

}
