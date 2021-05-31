/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.model.StudentTask;
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
    
    public StudentTask addStudentTask(StudentTask studentTask) throws SQLException {
        String sql = "insert into studenttaskmapper values(?,(select id from task where name = ?));"; // can be split
        jdbcTemplate.update(sql,studentTask.getId(),studentTask.getTask());
        return studentTask;
    }
    
    public StudentTask deleteStudentTask(StudentTask studentTask) throws SQLException {
        String sql = "delete from studenttaskmapper where sId=? and tId=(select id from task where name=?)";
        int numberOfRecordsAffected = jdbcTemplate.update(sql,studentTask.getId(),studentTask.getTask());
        if(numberOfRecordsAffected == 0) throw new SQLException("Please enter a valid studentId/taskName, refer showTasks");
        return studentTask;
    }
    
    public List<StudentTask> getStudentTasks(int id) throws SQLException {
        String sql = "select stm.sId as id,t.name as name from studenttaskmapper stm inner join task t on stm.tId=t.id where sId=?";
        List<StudentTask> tasks = jdbcTemplate.query(sql,new StudentTaskMapper(),id);
        // should handle the case when no student with id is present
        return tasks;
    }
    
}
