package com.sammy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammy.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findByVerificationCode(String code);
	
	
}
