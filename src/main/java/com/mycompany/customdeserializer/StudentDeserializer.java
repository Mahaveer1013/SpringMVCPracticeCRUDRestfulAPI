/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customdeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mycompany.model.Student;
import com.mycompany.model.Task;
import java.io.IOException;

/**
 *
 * @author Thammana Srinivas
 */
public class StudentDeserializer extends StdDeserializer<Student> {

    public StudentDeserializer() {
        this(null);
    } 

    public StudentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Student deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode jn = jp.getCodec().readTree(jp);
        JsonNode jnId = jn.get("id");
        JsonNode jnName = jn.get("name");
        JsonNode jnAge = jn.get("age");
        JsonNode jnCourse = jn.get("course");
        JsonNode jnTaskName = jn.get("task_name");
        int id = 0, age = 0;
        String name = null,course = null,taskName = null;
        if(jnId!=null)
            id = Integer.parseInt(jnId.asText()); //doubt - IntNode not working
        if(jnName!=null)
            name = jnName.asText();
        if(jnAge!=null)
            age = Integer.parseInt(jnAge.asText().equals("")?"0":jnAge.asText()); //doubt - IntNode not working
        if(jnCourse!=null)
            course = jnCourse.asText();
        if(jnTaskName!=null)
            taskName = jnTaskName.asText();
        if(jnTaskName==null)
            return new Student(id,name,age,course,null);
        return new Student(id,name,age,course,new Task(taskName));
        
    }
    
}
