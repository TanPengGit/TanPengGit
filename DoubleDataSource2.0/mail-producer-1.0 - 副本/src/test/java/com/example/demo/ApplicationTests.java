package com.example.demo;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tp.maill.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ApplicationTests {
	//开始注入数据源
	@Resource(name="masterDataSource")
	private DataSource masterDataSource;

	@Resource(name="slaveDataSource")
	private DataSource slaveDataSource;
	//结束注入数据源
	
	@Test
	public void contextLoads() throws Exception {
		Connection c1= masterDataSource.getConnection("root","root");
		System.err.println("c1:"+c1.getMetaData().getURL());
		Connection c2= slaveDataSource.getConnection("root","root");
		System.err.println("c2:"+c2.getMetaData().getURL());
	}

}
