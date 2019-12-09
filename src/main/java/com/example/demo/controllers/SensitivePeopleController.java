package com.example.demo.controllers;

import com.example.demo.entities.SensitivePeople;
import com.example.demo.services.SensitivePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main")
public class SensitivePeopleController {

    @Autowired
    public SensitivePersonService service;

    @RequestMapping("/getInfo/{id}")
    public SensitivePeople getPersonaInfo(@PathVariable String id){
        return service.getPersonInfo(id);
    }

    @RequestMapping("/getInfoList/{id}")
    public List<SensitivePeople> getPersonaInfoList(@PathVariable String id){
        return service.getPersonInfoList(id);
    }

//    @RequestMapping("/getMiName/{id}")
//    public List<String> getMiname(@PathVariable String id){
//        return service.getMiName(service.getPersonInfoList(id));
//    }
}
