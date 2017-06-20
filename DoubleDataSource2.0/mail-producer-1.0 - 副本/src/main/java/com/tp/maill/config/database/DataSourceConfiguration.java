package com.tp.maill.config.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Value("${druid.type}")//加载数据源
	private Class<? extends DataSource> dataSourceType;
	
 
	@Bean(name = "masterDataSource")
	@Primary//默认首选master   当类型相同加入@Primary后默认首选
	@ConfigurationProperties(prefix = "druid.master") //解析druid.master为前缀的配置，
	public DataSource masterDataSource() throws SQLException{
		DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();//创建数据源的时候把@ConfigurationProperties读取到的配置注入
		LOGGER.info("========MASTER: {}=========", masterDataSource);
		return masterDataSource;
	}
 
	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "druid.slave")
	public DataSource slaveDataSource(){
		DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
		LOGGER.info("========SLAVE: {}=========", slaveDataSource);
		return slaveDataSource;
	}
  
	@Bean   //初始化监控台,servlet
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
//      reg.setAsyncSupported(true);
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("allow", "localhost");
		reg.addInitParameter("deny","/deny");
//      reg.addInitParameter("loginUsername", "tp");
//      reg.addInitParameter("loginPassword", "sasa");
		LOGGER.info(" druid console manager init : {} ", reg);
		return reg;
  }

	@Bean    //过滤
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
		LOGGER.info(" druid filter register : {} ", filterRegistrationBean);
		return filterRegistrationBean;
	}
  
}
