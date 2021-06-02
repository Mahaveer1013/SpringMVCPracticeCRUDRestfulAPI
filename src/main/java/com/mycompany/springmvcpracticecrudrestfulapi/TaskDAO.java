/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.exceptions.CustomException;
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
    
    public Task addTask(String task) throws SQLException, CustomException {
        String sql = "insert into task (name) values(?)";
        // custom validation
        int numberOfRecordsModified = jdbcTemplate.update(sql,task);
        if(numberOfRecordsModified == 0)  throw new CustomException("Enter Valid Details");
        return new Task(task);
    }
    
    public List<Task> getAllTasks() throws SQLException {
        String sql = "select name from task";
        List<Task> tasks = jdbcTemplate.query(sql, new TaskMapper()); 
        return tasks;
    }
    
    public Task deleteTask(Task task) throws SQLException {
        String sql = "delete from task where name = ?";
        int numberOfRecordModified = jdbcTemplate.update(sql,task.getName());
        if (numberOfRecordModified == 0) throw new SQLException("There is no such task");
        return task;
    }
    
}
