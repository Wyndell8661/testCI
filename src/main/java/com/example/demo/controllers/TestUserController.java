package com.example.demo.controllers;


import com.example.demo.entities.TestUser;
import com.example.demo.mappers.TestUserMapper;
import com.example.demo.services.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestUserController {

    @Autowired
    TestUserService testUserService;

    @Autowired
    TestUserMapper mapper;

    @PostConstruct
    public void init(){
        System.out.println("init完成");
    }

    @PostMapping("insertUser")
    public Map<String, Object> PostMapping(@Valid @RequestBody TestUser user){
            Map<String, Object> resultMap = new HashMap<>();
            testUserService.insertUser(user);
            resultMap.put("resultCode", 200);
            resultMap.put("message", "成功");
            resultMap.put("id", user.getUserId());
            return resultMap;

//        else{
//            Map<String, Object> resultMap = new HashMap<>();
//            resultMap.put("resultCode", 400);
//            resultMap.put("message", "失败");
//            List<String> errorMessage = new ArrayList<>();
//            List<ObjectError> allErrors = result.getAllErrors();
//            for(ObjectError error:allErrors){
//                errorMessage.add(error.getDefaultMessage());
//            }
//            resultMap.put("errorMessage", errorMessage);
//            return resultMap;
//        }
    }


    @GetMapping("groupby")
    public List<Map<String, String>> groupBy(){
        List<Map<String, String>> map = mapper.groupBy();
        return map;
    }

    @GetMapping("count")
    public List<Map<String, Object>> count(){
        List<Map<String, Object>> map = mapper.count();
        return map;
    }
}
