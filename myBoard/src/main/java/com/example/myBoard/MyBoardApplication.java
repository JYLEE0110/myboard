package com.example.myBoard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.myBoard.**.mappers"})
@SpringBootApplication
public class MyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoardApplication.class, args);
	}

}
