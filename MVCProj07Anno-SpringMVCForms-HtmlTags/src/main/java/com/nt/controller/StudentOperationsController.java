package com.nt.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
	//@RequestMapping(value="/student_form",method=RequestMethod.GET)
	@GetMapping("/student_form")
	public  String  showForm() {  //form launching
		System.out.println("StudentOperationsController.showForm()");
		//return LVN
		return "register_student";
	}
	
	//@RequestMapping(value="/student_form",method=RequestMethod.POST)
	@PostMapping("/student_form")
	//public  String registerStudent(Map<String,Object> map,@ModelAttribute Student student) {  //form processing
	public  String registerStudent(Map<String,Object> map,@ModelAttribute("stud") Student st) {
		System.out.println("StudentOperationsController.registerStudent()");
		//no request processing logic
		
		//no model attributes
		  map.put("sysDate",LocalDateTime.now());
		  //return lvn
		  return "result";
	}

}//class
