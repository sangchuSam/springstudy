package com.hanul.spring;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// 지정한 클래스를 이용해 테스트 메서드를 수행하도록 지정해주는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class DataSourceTest {
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	//@Test
	//public void test() {
	//	try (Connection con = dataSource.getConnection()) {
	//		log.info("testConnection : {}", con);
	//		
	//	} catch (Exception e) {
	//		// TODO: handle exception
	//		e.printStackTrace();
	//	}
		//fail("Not yet implemented");
	//}
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection con = dataSource.getConnection()) {
			log.info("sqlSessionFactory : {}", sqlSessionFactory);
			log.info("con : {}", con);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}
}
