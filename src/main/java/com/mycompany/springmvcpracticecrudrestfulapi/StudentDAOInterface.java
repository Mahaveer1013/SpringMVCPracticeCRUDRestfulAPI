/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;
 
import com.mycompany.model.Student;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Thammana Srinivas
 */
public interface StudentDAOInterface {
    Student getStudent(int id) throws EmptyResultDataAccessException;
    
    Student addStudent(int id, Student student) throws SQLException;
    
    Student updateStudent(Student student) throws SQLException;
    
    Student deleteStudent(int id) throws SQLException;
    
    List<Student> getAllStudents() throws SQLException;
}
