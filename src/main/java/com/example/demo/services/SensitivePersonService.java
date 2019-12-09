package com.example.demo.services;

import com.example.demo.entities.SensitivePeople;
import com.example.demo.mappers.SenstivePeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensitivePersonService {
    @Autowired
    SenstivePeopleMapper mapper;

    public SensitivePeople getPersonInfo(String id){
        return mapper.getPersonInfo(id);
    }

    public List<SensitivePeople> getPersonInfoList(String id){
        return mapper.getPersonInfoList(id);
    }

//    public List<String> getMiName(List<SensitivePeople> list){
//        return  mapper.getMiName(list);
//    }
}
