package com.example.Repository;


import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.TargetDataSource;
import com.example.doMain.Emp;

public interface EmpRepositpry extends JpaRepository<Emp, Long>
{
	/***
	  * 根据ID查询
	  * @return
	  */
	@TargetDataSource(name="ds2")
	//从数据源、mysql从节点，读操作
	 public List<Emp> findByName(String Name);  
	
	@TargetDataSource(name="ds1")
	//主数据源、mysql主节点，写操作
	 public void deleteById(Long id);
}
