package com.vet.main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DBconnectionTest2 {

		@Autowired
		private DataSource dataSource;
		
		@Test
		void dbTest() throws Exception{
			Connection connection = dataSource.getConnection();
			assertNotNull(connection);
		}

	}


