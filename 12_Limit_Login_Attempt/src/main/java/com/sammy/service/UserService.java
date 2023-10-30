package com.sammy.service;

import com.sammy.entity.User;

public interface UserService {
	
	public User saveUser(User user,String url);
	
	public void removeSessionMessage();

	void sendEmail(User user, String url);
	
	public boolean verifyAccount(String verificationCode);

	public void increaseFailedAttempt(User user);
	
	public void resetAttempt(String email);
	
	public void lock(User user);
	
	public boolean unlockAccountTimeExpired(User user);
	
}
