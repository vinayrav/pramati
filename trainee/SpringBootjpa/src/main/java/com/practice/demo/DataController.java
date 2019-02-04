package com.practice.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

@RestController
public class DataController {
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@Autowired
	DataRepo datarepo;
	
	//@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
	@PostMapping(path="/data")    
	public Data addData(@RequestBody Data entry) {
		datarepo.save(entry);
		return entry;
	}
	
	
	@GetMapping("/data") 
	@ResponseBody
	public List<Data> getData(){ 
		return datarepo.findAll();
	}
	
	
	 @RequestMapping("/data/{bid}")
	    @ResponseBody
	    public Optional<Data> getidData(@PathVariable int bid){
		return datarepo.findById(bid);
	 }
	
	@DeleteMapping("/data/{bid}")
	public String deleteData(@PathVariable int bid) {
		Data d=datarepo.getOne(bid);
		datarepo.delete(d);
		return "deleted"+d;	
	}
	
	@PutMapping("/data")
	public Data CreateOrUpdate(@RequestBody Data data){
		datarepo.save(data);
		System.out.println("updated");
		return data;
	}
	
}


	
//	public ModelAndView getData(@RequestParam int bid) {
//		ModelAndView mv=new ModelAndView("show.jsp");
//		Data data=datarepo.findById(bid).orElse(null);
//		mv.addObject(data);
//		return mv;
//	}

	




