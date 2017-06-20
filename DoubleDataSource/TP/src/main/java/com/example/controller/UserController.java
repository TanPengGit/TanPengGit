package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.UserService;
import com.example.doMain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/doGetTp")
	public String getUserById(String uname,Model model){
		
		User u=userService.findByName(uname);
		
		model.addAttribute("use",u);
		
		return "User";
	}
	
	
}
