package com.caolinke.springboot.dao;

import com.caolinke.springboot.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入单条Student信息
     * @param student
     */
    public void addStudent(Student student){
        String sql = "insert into student(id,name,sex,age,pno,grade,remark) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setInt(3,student.getSex());
                preparedStatement.setInt(4,student.getAge());
                preparedStatement.setString(5,student.getPno());
                preparedStatement.setString(6,student.getGrade());
                preparedStatement.setString(7,student.getRemark());
            }
        });
    }

    /**
     * 批量插入student信息
     * @param studentList
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int addStudentList(List<Student> studentList){
        String sql = "insert into student(id,name,sex,age,pno,grade,remark) values(?,?,?,?,?,?,?)";
        int[] num = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,studentList.get(i).getId());
                preparedStatement.setString(2,studentList.get(i).getName());
                preparedStatement.setInt(3,studentList.get(i).getSex());
                preparedStatement.setInt(4,studentList.get(i).getAge());
                preparedStatement.setString(5,studentList.get(i).getPno());
                preparedStatement.setString(6,studentList.get(i).getGrade());
                preparedStatement.setString(7,studentList.get(i).getRemark());
            }

            @Override
            public int getBatchSize() {
                return studentList.size();
            }
        });
        return num.length;
    }

    /**
     * 根据id更新名称
     * @param name
     * @param id
     */
    public void updateStudent(String name, Integer id){
        String sql = "update student set name=? where id = ?";
        //jdbcTemplate.update(sql,new Object[]{name,id});
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,id);
            }
        });
    }

    /**
     * 根据id查看学生信息
     * @param id
     * @return
     */
    public Student findStudent(String id){
        Student student = new Student();
        String sql = "select * from student where id=?";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSex(resultSet.getInt("sex"));
                student.setAge(resultSet.getInt("age"));
                student.setPno(resultSet.getString("pno"));
                student.setGrade(resultSet.getString("grade"));
                student.setRemark(resultSet.getString("remark"));
            }
        });
        return student;
    }

    /**
     * 查询所有的学生信息
     * @return
     */
    public List<Student> findAllStudent(){
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from student order by pno";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSex(resultSet.getInt("sex"));
                student.setAge(resultSet.getInt("age"));
                student.setPno(resultSet.getString("pno"));
                student.setGrade(resultSet.getString("grade"));
                student.setRemark(resultSet.getString("remark"));
                studentList.add(student);
            }
        });
        return studentList;
    }

    /**
     * 根据id删除信息
     * @param id
     */
    public void delById(Integer id){
        String sql = "delete * from student where id=?";
        //jdbcTemplate.update(sql,new Object[]{id});
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,id);
            }
        });
    }
}
