package com.tp.maill.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.tp.maill.config.database.DataBaseContextHolder.DataBaseType;

@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered{
	
	public static final Logger LOGGER=LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);
	
	@Around("@annotation(readOnlyConnection)")
	public Object Proceed(ProceedingJoinPoint proceedingJoinPoint,ReadOnlyConnection readOnlyConnection)throws Throwable{
		try {
			LOGGER.info("-----------------is set SLAVE OK!------------");
			DataBaseContextHolder.setDataBaseType(DataBaseType.SLAVE);
			Object result=proceedingJoinPoint.proceed();
			return result;
		} finally {
			DataBaseContextHolder.clearDataBaseType();
			LOGGER.info("-----------------is Clear DataSource OK!------------");
		}
	}
	
	@Override
	public int getOrder() {
		return 0;
	}

}
