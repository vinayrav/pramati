package com.ts.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AController {
@RequestMapping("/")
public String NewFile() {
	return "NewFile.jsp";
}
@RequestMapping("/addAction")
public String addAction(Action action)
{
	
}

}
