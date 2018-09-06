package com.caolinke.springboot.controller;

import com.caolinke.springboot.dao.Student;
import com.caolinke.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class StudentController {

    @Autowired
    private Student student;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getInfo")
    public void findStudent(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始查询信息：");
        studentService.getStudentInfo();
    }
}
