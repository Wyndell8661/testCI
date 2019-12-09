package com.example.demo.mock;


import org.springframework.stereotype.Component;

@Component
public class RealDao {

    private String name = "RealDao";

    public void getName(){
        System.out.println(name);
    }
}
