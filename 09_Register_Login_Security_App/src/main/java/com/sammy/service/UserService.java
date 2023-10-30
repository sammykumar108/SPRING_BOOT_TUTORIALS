package com.sammy.service;

import com.sammy.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public void removeSessionMessage();

}
