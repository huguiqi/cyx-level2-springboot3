package com.cxy.level2.cxylevel2.controller;

import com.cxy.level2.cxylevel2.service.StudentService;
import com.cxy.level2.cxylevel2.dto.StudentDto;
import com.cxy.level2.cxylevel2.entity.Student;
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
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> list(@RequestBody StudentDto studentDto){
            return studentService.list(studentDto);
    }

    @GetMapping(value ="student",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> student(){
        return studentService.allStudents();
    }

    @PostMapping(value ="student")
    public String student(@RequestBody StudentDto studentDto){
        studentService.addOrUpdate(studentDto);
        return "ok";
    }


    @DeleteMapping(value ="student/{id}")
    public String student(@PathVariable("id") Long id){
        studentService.removeById(id);
        return "ok";
    }

}
