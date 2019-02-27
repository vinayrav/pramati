package com.practice.demo;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("homes")
	
	public ModelAndView homes(Data data) {
//		HttpSession session=req.getSession();
		//String name=req.getParameter("name");
		ModelAndView mv=new ModelAndView();
		//System.out.println("hello"+name);
		//session.setAttribute("nam",name);
		mv.addObject("obj",data);//object
		mv.setViewName("home");
		return mv;//view
	}

}
