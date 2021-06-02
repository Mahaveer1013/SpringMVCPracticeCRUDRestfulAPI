/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.constraintgroups.StudentDetails;
import com.mycompany.constraintgroups.StudentTaskDetails;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thammana Srinivas
 */
public class Student {
    
    @JsonProperty(value="id")
    @Min(value=1,message="Student Id must be atleast 1",groups={StudentDetails.class,StudentTaskDetails.class})
    private int studentId;
    
    @Size(min=3,message="Enter a valid name which has atleast 3 characters",groups=StudentDetails.class)
    private String name;
    
    @Min(value=17,message="Minimum age should be atleast 17",groups=StudentDetails.class)
    private int age;
    
    @Size(min=2,message="Minimum length of the course should atleast be 2",groups=StudentDetails.class)
    private String course;

    @JsonProperty(value="task_details")
    @Valid
    @NotNull(groups=StudentTaskDetails.class)
    private Task taskDetails; // multiple

    public Task getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(Task taskDetails) {
        this.taskDetails = taskDetails;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
}
