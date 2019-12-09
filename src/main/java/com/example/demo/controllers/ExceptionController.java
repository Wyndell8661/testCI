package com.example.demo.controllers;


import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {
    //处理哪一种类型的的异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map handleException(MethodArgumentNotValidException e){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code",1001);
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        map.put("message",message);
        map.put("result",null);
        map.put("success",false);
        return map;
    }
}
