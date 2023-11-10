package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.Employee;
import org.springframework.beans.BeanUtils;

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
public class EmployeeDto implements Serializable {

    private String id,name,dept,position;
    private float salary;
    private String addOrEdit = "add";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee toEntity() {
        Employee employee = new Employee();
        BeanUtils.copyProperties(this, employee,"addOrEdit");
        return employee;
    }

    public boolean hasAdd() {
        if ("add".equalsIgnoreCase(this.addOrEdit))
            return true;
        return false;
    }
}
