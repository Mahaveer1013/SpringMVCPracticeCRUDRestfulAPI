/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.constraintgroups.StudentTaskDetails;
import com.mycompany.exceptions.CustomException;
import com.mycompany.model.Task;
import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thammana Srinivas
 */

@RestController
public class TaskController {
    
    @Autowired
    private TaskDAO taskDAO;
    
    @PostMapping("/task/{task}")   // /task is better than /teachertask because api should be generic
    public Task addTask(@PathVariable String task, @Validated(StudentTaskDetails.class) @RequestBody Task taskObject) throws SQLException, CustomException {
        return taskDAO.addTask(task);
    }
    
    @GetMapping("/task")
    public List<Task> getAllTasks() throws SQLException {
        return taskDAO.getAllTasks();
    }
    
    @DeleteMapping("/task/{task}")
    public Task deleteTask(@PathVariable String task) throws SQLException {
        return taskDAO.deleteTask(new Task(task));
    }
}
