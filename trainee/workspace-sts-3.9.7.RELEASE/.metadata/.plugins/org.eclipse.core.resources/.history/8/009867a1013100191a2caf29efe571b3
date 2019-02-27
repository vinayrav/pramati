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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 //import org.springframework.web.servlet.ModelAndView;

@RestController
public class DataController {
	
	@Autowired
	DataRepo datarepo;
	
	//@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
	//To add new entry to the data
	@PostMapping(path="/data")    
	public Data addData(@RequestBody Data entry) {
		datarepo.save(entry);
		return entry;
	}
	
	//To get the complete data
	@GetMapping("/data") 
	//@ResponseBody--when used with Controller
	public List<Data> getData(){ 
		return datarepo.findAll();
	}
	
	//To get specific details of data
	//"id" to be given to get desired data
	 @RequestMapping("/data/{id}")
	    //@ResponseBody
	    public Optional<Data> getidData(@PathVariable int id){
		return datarepo.findById(id);
	 }
	
	 
	 //To delete specific entry
	 //"id" of the entry to be deleted is given
	@DeleteMapping("/data/{id}")
	public String deleteData(@PathVariable int id) {
		Data d=datarepo.getOne(id);
		datarepo.delete(d);
		return "deleted"+d;	
	}
	
	//To Update existing data
	@PutMapping("/data")
	public Data createOrUpdate(@RequestBody Data data){
		datarepo.save(data);
		//System.out.println("updated");
		return data;
	}
	
}

	




