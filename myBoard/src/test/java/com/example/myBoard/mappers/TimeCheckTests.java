package com.example.myBoard.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class TimeCheckTests {

    // 의존성주입 
    @Autowired
    private TimeCheck timeCheck;


    // TimeCheck
    @Test
    public void timeCheck() {
        log.info("timeCheck");
        timeCheck.getTime();
    }
    
}
