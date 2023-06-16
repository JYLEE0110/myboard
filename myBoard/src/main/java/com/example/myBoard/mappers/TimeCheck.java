package com.example.myBoard.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeCheck {
    
    // mybatis timeCheck 
    String getTime();
}
