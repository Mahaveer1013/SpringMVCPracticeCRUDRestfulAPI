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
public class StudentDetailsMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student s = new Student();
     
        s.setId(rs.getInt("sId"));
        s.setName(rs.getString("name"));
        s.setAge(rs.getInt("age"));
        s.setCourse(rs.getString("course"));
        s.setTaskDetails(new Task(rs.getString("task")));
        
        return s;
    }
    
}
