package com.caolinke.springboot.service;

import com.caolinke.springboot.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
@Component
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getStudentInfo(){
        String sql = "select * from student";
       jdbcTemplate.query(sql, new RowCallbackHandler() {
           @Override
           public void processRow(ResultSet resultSet) throws SQLException {
               Student student = new Student();
               student.setName(resultSet.getString("name"));
               student.setAge(resultSet.getInt("age"));
               student.setGender(resultSet.getInt("sex") == 1?"男":"女");
               student.setAddress(resultSet.getString("addr"));
               String hobby = resultSet.getString("hobby");
               String[] hobbys = hobby.split(",");
                student.setHobbys(Arrays.asList(hobbys));
               System.out.println(student);
           }
       });

    }
}
