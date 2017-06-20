package com.example.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.EmpRepositpry;
import com.example.demo.TargetDataSource;
import com.example.doMain.Emp;

@Service("empService")
@Transactional
public class EmpService {

	@Autowired
	private EmpRepositpry empRepositpry;
	
	@TargetDataSource(name="ds2")
	public List<Emp> findByName(String Name){
		return empRepositpry.findByName(Name);
	}
	@TargetDataSource(name="ds1")
	 public void deleteById(int id){
		  empRepositpry.deleteById((long)id);
	 };
}
