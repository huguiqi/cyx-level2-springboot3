package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.Dept;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/09/16:25
 * @summary:
 */
public class DeptDto  implements Serializable {

    private String id,manager,name;
    private String addOrEdit = "add";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddOrEdit() {
        return addOrEdit;
    }

    public void setAddOrEdit(String addOrEdit) {
        this.addOrEdit = addOrEdit;
    }

    public Dept toEntity() {
        Dept dept = new Dept();
        BeanUtils.copyProperties(this, dept,"addOrEdit");
        return dept;
    }

    public boolean hasAdd() {
        if ("add".equalsIgnoreCase(this.addOrEdit))
            return true;
        return false;
    }
}
