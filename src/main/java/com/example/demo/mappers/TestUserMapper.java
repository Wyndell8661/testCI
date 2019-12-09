package com.example.demo.mappers;

import com.example.demo.entities.TestUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TestUserMapper {
    Long insertUser(TestUser user);

    List<Map<String, String>> groupBy();

    List<Map<String, Object>> count();
}
