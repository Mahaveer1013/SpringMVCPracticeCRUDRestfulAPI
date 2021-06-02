/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Thammana Srinivas
 */
public class StudentTaskMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student s = new Student();
        
        s.setStudentId(rs.getInt("id"));
        s.setTaskDetails(new Task(rs.getString("name")));
        
        return s;
    }
    
}
