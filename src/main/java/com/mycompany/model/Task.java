/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import javax.validation.constraints.Size;

/**
 *
 * @author Thammana Srinivas
 */
public class Task {
    
    @Size(min=4,message="Enter a task with atleast 4 characters")
    private String task;
    
    public Task() {
        
    }

    public Task(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
}
