package com.tp.maill.config.database;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.aspectj.apache.bcel.util.ClassLoaderRepository.SoftHashMap;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/***
 * 
 * @author tp
 *
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})//等待DataSourceConfiguration加载完之后再加载本文件
public class MybatisConfiguration extends MybatisAutoConfiguration{
	//开始注入数据源
	@Resource(name="masterDataSource")
	private DataSource masterDataSource;

	@Resource(name="slaveDataSource")
	private DataSource slaveDataSource;
	//结束注入数据源
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		return super.sqlSessionFactory(DataSouceProxy());
	}
	
	public AbstractRoutingDataSource DataSouceProxy(){
		ReadWriteSplitRoutingDataSource proxy=new ReadWriteSplitRoutingDataSource();
		SoftHashMap dataSource=new ClassLoaderRepository.SoftHashMap();
		dataSource.put(DataBaseContextHolder.getDataBaseType().MASTER, masterDataSource);
		dataSource.put(DataBaseContextHolder.getDataBaseType().SLAVE, slaveDataSource);
		proxy.setDefaultTargetDataSource(masterDataSource);//默认为主
		//装入主从数据源
		proxy.setTargetDataSources(dataSource);
		return proxy;
	}
	
	
	
	
}
