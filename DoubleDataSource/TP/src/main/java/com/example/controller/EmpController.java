package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.EmpService;
import com.example.demo.TargetDataSource;
import com.example.doMain.Emp;

@RestController
@RequestMapping("/Emp")
public class EmpController {
	
	
	@Autowired
	private EmpService empService;
	
	@TargetDataSource(name="ds2")
	@RequestMapping("/doGetEmp")
	public List<Emp> getUserById(String Name,Model model){
		System.out.println(Name);
		List<Emp> u=empService.findByName(Name);
		return u;
	}
	
	@TargetDataSource(name="ds1")
	@RequestMapping("/doDeleteById")
	 public void deleteById(int id){
		empService.deleteById(id);
	 };
}
