package com.cxy.level2.cxylevel2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/09/16:22
 * @summary:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeKPI implements Serializable {

    private String id,dept,name,position,kpi,kpiId,comments;

    private float salary;




}
