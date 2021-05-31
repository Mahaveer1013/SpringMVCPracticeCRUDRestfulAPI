/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.model.StudentDetails;
import com.mycompany.model.StudentDetailsMapper;
import com.mycompany.model.Task;
import com.mycompany.model.TaskMapper;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Thammana Srinivas
 */
public class TaskDAO {
        
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Task addTask(Task task) throws SQLException {
        String sql = "insert into task (name) values(?)";
        jdbcTemplate.update(sql,task.getTask());
        return task;
    }
    
    public List<Task> getAllTasks() throws SQLException {
        String sql = "select name from task";
        List<Task> tasks = jdbcTemplate.query(sql, new TaskMapper()); 
        return tasks;
    }
    
    public Task deleteTask(Task task) throws SQLException {
        String sql = "delete from task where name = ?";
        int numberOfRecordModified = jdbcTemplate.update(sql,task.getTask());
        if (numberOfRecordModified == 0) throw new SQLException("There is no such task");
        return task;
    }
    
    public List<StudentDetails> getStudentDetails() throws SQLException {
        String sql = "select s.id as sId,s.name,s.age,s.course,t.name as task from student s inner join studenttaskmapper stm on s.id=stm.sId inner join task t on stm.tId=t.id";
        List<StudentDetails> studentDetails = jdbcTemplate.query(sql, new StudentDetailsMapper());
        return studentDetails;
    }
    
}
