/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.exceptions.CustomException;
import com.mycompany.model.Student;
import com.mycompany.model.StudentTaskMapper;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Thammana Srinivas
 */

public class StudentTaskDAO {
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Student addStudentTask(int id, Student student) throws SQLException, CustomException {
        String sql = "insert into studenttaskmapper values(?,(select id from task where name = ?));";
        int numberOfRecordsAffected = jdbcTemplate.update(sql,id,student.getTaskDetails().getName());
        if(numberOfRecordsAffected==0) throw new CustomException("Enter Valid Details");
        return student;
    }
    
    public Student deleteStudentTask(Student student) throws SQLException {
        String sql = "delete from studenttaskmapper where sId=? and tId=(select id from task where name=?)";
        int numberOfRecordsAffected = jdbcTemplate.update(sql,student.getStudentId(),student.getTaskDetails().getName());
        if(numberOfRecordsAffected == 0) throw new SQLException("Please enter a valid studentId/taskName, refer showTasks");
        return student;
    }
    
    public List<Student> getStudentTasks(int id) throws SQLException {
        String sql = "select stm.sId as id,t.name as name from studenttaskmapper stm inner join task t on stm.tId=t.id where sId=?";
        List<Student> tasks = jdbcTemplate.query(sql,new StudentTaskMapper(),id);
        return tasks;
    }
    
}
