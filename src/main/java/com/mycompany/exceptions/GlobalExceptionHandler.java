/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceptions;

import com.mycompany.springmvcpracticecrudrestfulapi.Reply;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Thammana Srinivas
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
       
    @ExceptionHandler(CustomException.class)   
    public ResponseEntity<Reply> fieldsEmpty(CustomException cE) {
        return new ResponseEntity<>(new Reply(cE.getMsg()),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Reply> nullPointerExceptionHandler(NullPointerException nPE) {
        return new ResponseEntity<>(new Reply(nPE.getMessage()),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Reply> validationFailed(MethodArgumentNotValidException ex) {
        BindingResult br = ex.getBindingResult();
        StringBuilder errorMessages = new StringBuilder();
        int i = 0;
        for(ObjectError oE: br.getAllErrors()) {
            ++i;
            if(i==1) errorMessages.append(oE.getDefaultMessage());
            else{
                errorMessages.append(", ");
                errorMessages.append(oE.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(new Reply(errorMessages.toString()),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Reply> sqlProblem(SQLException sqlEx) {
        return new ResponseEntity<>(new Reply("Please Enter Valid Details"),HttpStatus.BAD_REQUEST);
        // sqlEx.getMessage Message is not returned because architecture details are revealed
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Reply> sqlProblem(EmptyResultDataAccessException erdaeEx) {   
        return new ResponseEntity<>(new Reply("No record found"),HttpStatus.BAD_REQUEST);
        // erdaeEx.getDefault Message is not returned because architecture details are revealed
    }
    
}
