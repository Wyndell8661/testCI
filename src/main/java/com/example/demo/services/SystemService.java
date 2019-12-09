package com.example.demo.services;


import com.example.demo.entities.Systems;
import com.example.demo.mappers.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    @Autowired
    public SystemMapper systemMapper;

    public List<Systems> getAllSystems(){
        return systemMapper.getAllSystems();
    }
}
