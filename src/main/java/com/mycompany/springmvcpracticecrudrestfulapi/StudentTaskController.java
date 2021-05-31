/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.model.StudentTask;
import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thammana Srinivas
 */
@RestController
@RequestMapping("/student")
public class StudentTaskController {
    
    @Autowired
    private StudentTaskDAO studentTaskDAO;
    
    @PostMapping("/task")
    public StudentTask addStudentTask(@Valid @RequestBody StudentTask studentTask) throws SQLException {
        return studentTaskDAO.addStudentTask(studentTask);
    }
    
    @DeleteMapping("/{id}/task/{task}")
    public StudentTask deleteStudentTask(@PathVariable int id, @PathVariable String task) throws SQLException {
        StudentTask studentTask = new StudentTask();
        studentTask.setId(id);
        studentTask.setTask(task);
        return studentTaskDAO.deleteStudentTask(studentTask);
    } 
    
    @GetMapping("/{id}/task")
    public List<StudentTask> getStudentTasks(@PathVariable int id) throws SQLException {
        return studentTaskDAO.getStudentTasks(id);
    }
    
}
