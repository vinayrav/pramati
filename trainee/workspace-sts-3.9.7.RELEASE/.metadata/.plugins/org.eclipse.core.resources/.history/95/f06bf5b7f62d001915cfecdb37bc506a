package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@Autowired
	DataRepo datarepo;
	@PostMapping("/register")    
	public String signup(Data newentry){
		datarepo.save(newentry);
		return "login.jsp";
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "logout.jsp";
		

	}

}
