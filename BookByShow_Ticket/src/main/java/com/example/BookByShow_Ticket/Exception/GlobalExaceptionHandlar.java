package com.example.BookByShow_Ticket.Exception;


import com.example.BookByShow_Ticket.ApiConstant.ApiResponce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExaceptionHandlar {


    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponce> resourceNotFoundExceptionHandlar(ResourceNotFoundException ex){
     String msg= ex.getMessage();
        ApiResponce apiRespones= ApiResponce.builder()
             .msg(msg)
             .build();
     return new ResponseEntity<>(apiRespones, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodNotFoundExceptionHandler(MethodArgumentNotValidException ex){

        Map<String,String> handel= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError)error).getField();
            String message= error.getDefaultMessage();
            handel.putIfAbsent(fieldName,message);

        });
        return new ResponseEntity<Map<String,String>>(handel,HttpStatus.BAD_REQUEST);


    }



}
