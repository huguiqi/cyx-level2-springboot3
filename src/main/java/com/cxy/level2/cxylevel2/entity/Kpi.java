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
 * @since: 2023/11/14/11:55
 * @summary:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kpi {
    private String id, employeeId,leader,kpi,comments;


}
