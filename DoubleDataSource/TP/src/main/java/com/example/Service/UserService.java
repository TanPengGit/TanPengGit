package com.example.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;
import com.example.doMain.User;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User findByName(String uname){
		
		return userRepository.findByName(uname);
		
	}
}
