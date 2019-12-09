package com.example.demo.services;

import com.example.demo.entities.TestUser;
import com.example.demo.mappers.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestUserService {

    @Autowired
    TestUserMapper testUserMapper;

    @Transactional
    public Long insertUser(TestUser user){
        return testUserMapper.insertUser(user);
    }
}
