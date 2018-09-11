package com.caolinke.springboot.service;

import com.caolinke.springboot.dao.StudentDao;
import com.caolinke.springboot.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 查询所有的信息
     * @return
     */
    public List<Student> findStudentList(){
        return studentDao.findAllStudent();
    }

}
