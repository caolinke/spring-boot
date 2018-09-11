package com.caolinke.springboot.controller;

import com.caolinke.springboot.dao.entity.Student;
import com.caolinke.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
   public String findAll(Model model){
      List<Student> list =  studentService.findStudentList();
      model.addAttribute("users",list);
      return "/user/UserList";
   }
}
