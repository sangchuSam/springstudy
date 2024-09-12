package com.hanul.spring;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OracleConnectionTest {

	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USER = "hanul";
	private final static String PW= "0000";
	
	// static 초기화 블럭
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try (Connection conn = DriverManager.getConnection(URL,USER,PW)) {
			log.info("conn : {}", conn);
			System.out.println("conn : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		fail("Not yet implemented");
		//log.info(DRIVER);
	}

}
