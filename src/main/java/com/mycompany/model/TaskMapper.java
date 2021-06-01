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
public class TaskMapper implements RowMapper<Task>{

    @Override
    public Task mapRow(ResultSet rs, int i) throws SQLException {
        Task task = new Task();
        
        task.setName(rs.getString("name"));
        
        return task;
    }
    
}
