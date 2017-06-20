package com.example.demo;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/***
 * 动态数据源
 * @author tp
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
