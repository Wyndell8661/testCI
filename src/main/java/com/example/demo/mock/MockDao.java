package com.example.demo.mock;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MockDao {

    private  String name = "MockDao";

    public List<String> getName(String id){
        return Arrays.asList("hello","world");
    }

    public void testMock(){
        System.out.println("不为mock");
    }
}
