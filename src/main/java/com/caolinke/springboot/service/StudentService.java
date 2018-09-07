package com.caolinke.springboot.service;

import com.caolinke.springboot.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
@Component
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudentInfo(){
        List<Student> list = new ArrayList<>();
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
               list.add(student);
           }
       });
        return list;
    }

    public void insertInfo(Student student){
        String sql = "insert into student(id,name,sex,age,addr,hobby) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setInt(3,Integer.parseInt(student.getGender()));
                preparedStatement.setInt(4,student.getAge());
                preparedStatement.setString(5,student.getAddress());
                preparedStatement.setString(6,(student.getHobbys()).toString());
            }
        });
        System.out.println("数据插入成功");
    }
}
