package com.example.demo.mock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockService {

    private String name = "MockService";

    @Autowired
    MockDao mockDao;

    @Autowired
    RealDao realDao;

    public void getName(){
        System.out.println("执行mock方法");
        List<String> names = mockDao.getName("aaaa");
        System.out.println(names.toString());
        System.out.println("mock方法执行完成");
    }

    public void testMock(){
        System.out.println("不为mock");
    }
}
