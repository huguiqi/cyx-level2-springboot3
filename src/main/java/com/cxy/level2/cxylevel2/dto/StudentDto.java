package com.cxy.level2.cxylevel2.dto;

import com.cxy.level2.cxylevel2.entity.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @version v1
 * @Author: sam.hu (huguiqi@zaxh.cn)
 * @Copyright (c) 2023, zaxh Group All Rights Reserved.
 * @since: 2023/11/02/20:55
 * @summary:
 */


public class StudentDto implements Serializable {

    private Long id;
    private String name;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birth;

    private String photoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Student toEntity() {
        Student entity = new Student();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }

    public boolean hasAdd() {
        if (this.id == null)
            return true;
        return false;
    }
}
