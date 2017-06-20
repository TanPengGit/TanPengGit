package com.tp.maill.config.database;

public class DataBaseContextHolder {
	
		//定义枚举
		public enum DataBaseType{
			MASTER,SLAVE
		}
		//必须使用线程安全容器，否则数据源可能会乱
		private static final ThreadLocal<DataBaseType> contextHolder=new ThreadLocal<DataBaseType>();
		
		//放数据源
		public static void setDataBaseType(DataBaseType dataBaseType){
			if (dataBaseType==null) throw new NullPointerException();
			contextHolder.set(dataBaseType);
		}
		//取数据源
		public static DataBaseType getDataBaseType(){
			return contextHolder.get()==null? DataBaseType.MASTER : contextHolder.get();
		}
		
		//注意！每次放完数据源必须清空，否则影响下一操作
		public static void clearDataBaseType(){
			contextHolder.remove();
		}
		
}
