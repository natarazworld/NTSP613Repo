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
	
	@GetMapping("/student_form")
	public  String  showForm(@ModelAttribute("stud")Student st) {  //form launching
		System.out.println("StudentOperationsController.showForm()");
		//return LVN
		return "register_student";
	}
	
	@PostMapping("/student_form")
	public  String registerStudent(Map<String,Object> map,@ModelAttribute("std") Student st) {
		System.out.println("StudentOperationsController.registerStudent()");
		//no request processing logic
		
		//no model attributes
		  map.put("sysDate",LocalDateTime.now());
		  //return lvn
		  return "result";
	}

}//class
