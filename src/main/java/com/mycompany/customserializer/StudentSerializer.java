/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mycompany.model.Student;
import java.io.IOException;

/**
 *
 * @author Thammana Srinivas
 */
public class StudentSerializer extends StdSerializer<Student> {

    public StudentSerializer() {
        this(null);
    }

    public StudentSerializer(Class<Student> t) {
        super(t);
    }
    
    @Override
    public void serialize(Student student, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        // jg - to create new json object
        jg.writeStartObject();
        jg.writeNumberField("id",student.getStudentId());
        jg.writeStringField("name",student.getName());
        jg.writeNumberField("age",student.getAge());
        jg.writeStringField("course",student.getCourse());
        if(student.getTaskDetails()!=null)
            jg.writeStringField("task_name",student.getTaskDetails().getName());
        jg.writeEndObject();
    }
    
}
