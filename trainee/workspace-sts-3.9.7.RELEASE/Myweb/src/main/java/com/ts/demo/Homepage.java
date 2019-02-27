package com.ts.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homepage {
	@RequestMapping("home")
	public String show() {
		System.out.println("Hi home");
		return "home.jsp";
	}

}
