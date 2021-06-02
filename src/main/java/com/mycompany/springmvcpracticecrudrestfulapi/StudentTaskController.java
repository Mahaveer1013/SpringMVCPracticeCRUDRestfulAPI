/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import com.mycompany.constraintgroups.StudentTaskDetails;
import com.mycompany.exceptions.CustomException;
import com.mycompany.model.Student;
import com.mycompany.model.Task;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    
    @PostMapping("/{id}/task") 
    public Student addStudentTask(@PathVariable int id, @Validated(StudentTaskDetails.class) @RequestBody Student student) throws SQLException, CustomException {
        return studentTaskDAO.addStudentTask(id,student);
    }
    
    @DeleteMapping("/{id}/task/{task}")
    public Student deleteStudentTask(@PathVariable int id, @PathVariable String task) throws SQLException {
        Student student = new Student();
        student.setStudentId(id);
        student.setTaskDetails(new Task(task));
        return studentTaskDAO.deleteStudentTask(student);
    } 
    
    @GetMapping("/{id}/task")
    public List<Student> getStudentTasks(@PathVariable int id) throws SQLException {
        return studentTaskDAO.getStudentTasks(id);
    }
    
}
