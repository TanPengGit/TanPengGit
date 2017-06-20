package com.example.Repository;

import java.util.List;


import com.example.doMain.User;


public interface TRepository //extends JpaRepository<User, Long>
{
	 /***
	  * 根据ID查询User
	  * @return
	  */
	 public List<User> findByName();  
	  
	/**
	 *  Or --- 等价于 SQL 中的 or 关键字，
	 * @param Name
	 * @param Id
	 * @return
	 */
	 public List<User> findByNameOrId(String Name,Long Id);  
	  	
	 /**
	  * Between --- 等价于 SQL 中的 between 关键字，  
	  * @param Id
	  * @return
	  */
	 public List<User> findById(Long Id);  
	  
	 /**
	  * LessThan --- 等价于 SQL 中的 "<"，
	  * @param id
	  * @return
	  */
	 public List<User> findByIdLessThan(int id);  
	  
	 /**
	  * GreaterThan --- 等价于 SQL 中的">"，
	  * @param i
	  * @return
	  */
	 public List<User> findByIdGreaterThan(int i);  
	  
	 /**
	  * IsNull --- 等价于 SQL 中的 "is null"，
	  * @return
	  */
	 public List<User> findByNameIsNull();  
	  
	 /**
	  * IsNotNull --- 等价于 SQL 中的 "is not null"
	  * @return
	  */
	 public List<User> findByNameIsNotNull();  
	  
	 /**
	  * NotNull --- 与 IsNotNull 等价；  
	  * @return
	  */
	 public List<User> findByNameNotNull();  
	  
	 /**
	  * Like --- 等价于 SQL 中的 "like"
	  * @param name
	  * @return
	  */
	 public List<User> findByNameLike(String name);  
	  
	 /**
	  * NotLike --- 等价于 SQL 中的 "not like"，
	  * @param name
	  * @return
	  */
	 public List<User> findByNameNotLike(String name);  
	  
	 /**
	  * OrderBy --- 等价于 SQL 中的 "order by"
	  * @return
	  */
	 public List<User>findByNameNotNullOrderByIdAsc();  
	  
	 /**
	  * Not --- 等价于 SQL 中的 "！ ="， 
	  * @param name
	  * @return
	  */
	 public List<User> findByNameNot(String name);  
	  
	 /**
	  * In --- 等价于 SQL 中的 "in"，
	  * @param name
	  * @return
	  */
	 public List<User> findByNameIn(String name);  
	  
	 /**
	  * NotIn --- 等价于 SQL 中的 "not in"，
	  * @param name
	  * @return
	  */
	 public List<User> findByNameNotIn(String name);  
}
