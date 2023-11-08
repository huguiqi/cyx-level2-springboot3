package com.cxy.level2.cxylevel2.service;

import com.cxy.level2.cxylevel2.dao.mapper.StudentMapper;
import com.cxy.level2.cxylevel2.dto.StudentDto;
import com.cxy.level2.cxylevel2.entity.Student;
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
public class StudentService {

    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> list(StudentDto studentDto) {
        return studentMapper.select(studentDto.toEntity());
    }

    public List<Student> allStudents() {
        return studentMapper.selectAll();
    }

    public void addOrUpdate(StudentDto studentDto) {
        if (studentDto.hasAdd())
            studentMapper.insert(studentDto.toEntity());
        else
            studentMapper.update(studentDto);
    }

    public void removeById(Long id) {
        studentMapper.deleteById(id);
    }
}
