package com.example.demo.mappers;

import com.example.demo.entities.SensitivePeople;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenstivePeopleMapper {

    SensitivePeople getPersonInfo(String id);


    List<SensitivePeople> getPersonInfoList(String id);

}
