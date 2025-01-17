package com.hanul.spring;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class MyBatisTest {
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void testSession() {
		try (SqlSession session = sqlFactory.openSession()) {
			log.info("session : {}", sqlFactory);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//fail("Not yet implemented");
	}

}
