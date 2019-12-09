package com.example.demo.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Systems;
import com.example.demo.services.SystemService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemServiceTest {

    @Autowired
    SystemService systemService;

    @Test
    public void testGetAllSystems(){
        List<Systems> allSystems = systemService.getAllSystems();
        System.out.println(allSystems.toString());
    }
}
