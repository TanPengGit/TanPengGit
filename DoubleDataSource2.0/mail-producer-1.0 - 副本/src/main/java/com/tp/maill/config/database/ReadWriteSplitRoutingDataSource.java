package com.tp.maill.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 实现数据源切换
 * @author Maibenben
 *
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource{
	//AbstractRoutingDataSource代理类可实现多数据源切换
	@Override
	protected Object determineCurrentLookupKey() {
		return DataBaseContextHolder.getDataBaseType();
	}
	
}
