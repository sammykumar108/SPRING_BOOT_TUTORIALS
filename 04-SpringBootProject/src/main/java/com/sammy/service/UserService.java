package com.sammy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sammy.repository.UserDao;

@Service
public class UserService {

	//setter injection
	@Autowired
	private UserDao userDao;
	
	public String saveUser() {

		boolean f = userDao.save();
		if (f) {
			return "Register Success";
		}
		else {
			return "server Error";
		}
		
	}

}
