package com.example.demo.mappers;

import com.example.demo.entities.Systems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemMapper
{
    List<Systems> getAllSystems();
}
