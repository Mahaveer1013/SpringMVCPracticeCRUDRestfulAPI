/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.model.Student;
import com.mycompany.model.StudentMapper;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Thammana Srinivas
 */

public class StudentDAO implements StudentDAOInterface {
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Student getStudent(int id) throws EmptyResultDataAccessException {
        String sql = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
        return student;
    }
    
    @Override
    public Student addStudent(Student student) throws SQLException {
        int theStudentId = student.getStudentId();
        String sql = "insert into student values(?,?,?,?);";
        jdbcTemplate.update(sql,theStudentId,student.getName(),student.getAge(),student.getCourse());  // returns number of rows affected
        return student;
    }
    
    @Override
    public Student updateStudent(Student student) throws SQLException {
        String sql = "update student set id=?,name=?,age=?,course=? where id=?;";
        int numberOfRowsEffected = jdbcTemplate.update(sql,student.getStudentId(),student.getName(),student.getAge(),student.getCourse(),student.getStudentId());
        if(numberOfRowsEffected == 0) throw new SQLException("No Record found where studentId is "+student.getStudentId());
        return student;
    }
    
    @Override
    public Student deleteStudent(int id) throws SQLException {
        String sql = "delete from student where id = ?";
        Student stud = getStudent(id);
        int numberOfRowsEffected = jdbcTemplate.update(sql,id);
        if(numberOfRowsEffected == 0) throw new SQLException("No Record found where studentId is "+id);
        return stud;
    }
    
    @Override
    public List<Student> getAllStudents() throws SQLException {
        String sql = "select * from student";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    } 
    
}
