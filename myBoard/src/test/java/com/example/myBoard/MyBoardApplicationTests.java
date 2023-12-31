package com.example.myBoard;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class MyBoardApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
	}

	@Test
	public void testConnection() {
		try (Connection connection = dataSource.getConnection()) {
			log.info("isOkgConnetion=====================================================");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
