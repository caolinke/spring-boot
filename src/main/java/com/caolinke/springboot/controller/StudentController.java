package com.caolinke.springboot.controller;

import com.caolinke.springboot.dao.Student;
import com.caolinke.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private Student student;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getInfo")
    public String findStudent(Model model){
        System.out.println("开始查询信息：");
        List<Student> list = studentService.getStudentInfo();
        System.out.println("得到list: " + list.get(0));
        model.addAttribute("users",list);
        return "/user/UserList";
    }

    @RequestMapping("/InsertInfo")
    public String insertInfo(){
        Student student1 = new Student();
        List<String> list = new ArrayList<>();
        list.add("篮球");
        student1.setHobbys(list);
        student1.setAddress("");
        student1.setAge(23);
        student1.setName("张三");
        student1.setGender("1");
        student1.setId(3);
        studentService.insertInfo(student1);
        System.out.println("执行插入方法结束");
        return "index";
    }
}
