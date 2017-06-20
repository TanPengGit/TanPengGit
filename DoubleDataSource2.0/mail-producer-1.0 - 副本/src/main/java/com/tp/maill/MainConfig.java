package com.tp.maill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/***
 * 基础配置类
 * @author Maibenben
 *
 */
@EnableWebMvc //启用了Spring MVC
@Configuration//让Spring boot 启动项目时识别当前配置类
@ComponentScan({"com.tp.mail.*"})  //扫描器，扫描Service,controller等注解
@MapperScan(basePackages="com.tp.mail.mapper")//扫描mapper
//如果要扫描xml的话使用@ImportResouorce(Value)
public class MainConfig {

}
	