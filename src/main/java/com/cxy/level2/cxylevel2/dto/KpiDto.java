package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.Kpi;
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
 * @since: 2023/11/14/11:29
 * @summary:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KpiDto {

    private String id, employeeId,leader,kpi,comments;

    public Kpi toEntity() {
        Kpi kpi = new Kpi();
        BeanUtils.copyProperties(this,kpi);
        return kpi;
    }
}
