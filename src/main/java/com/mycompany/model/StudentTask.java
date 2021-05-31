/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Thammana Srinivas
 */
public class StudentTask {
    
    @Min(value=1,message="Please Enter positive value")
    private int id;
    
    @Size(min=3,message="The length of the task should be atleast 3")
    private String task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
}
