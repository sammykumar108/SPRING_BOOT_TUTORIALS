package com.sammy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sammy.service.UserService;

@Controller
public class HomeController {

	//setter injection
//	@Autowired
	private UserService userService;
	
	
	//constructor injection
	public HomeController(UserService userService)
	{
		System.out.println("Constructor injection");
		this.userService=userService;
	}
	
	
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/createUser")
	public String registerUser()
	{
		String msg=userService.saveUser();
		System.out.println(msg);
		
		return "successs";
	}
	
}
