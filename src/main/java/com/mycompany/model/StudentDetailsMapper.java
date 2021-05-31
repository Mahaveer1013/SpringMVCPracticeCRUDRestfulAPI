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
public class StudentDetailsMapper implements RowMapper<StudentDetails> {

    @Override
    public StudentDetails mapRow(ResultSet rs, int i) throws SQLException {
        StudentDetails sd = new StudentDetails();
     
        sd.setSId(rs.getInt("sId"));
        sd.setName(rs.getString("name"));
        sd.setAge(rs.getInt("age"));
        sd.setCourse(rs.getString("course"));
        sd.setTask(rs.getString("task"));
        
        return sd;
    }
    
}
