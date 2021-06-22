package com.nt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	/*@GetMapping("/processurl")
	public String  readParams(@RequestParam("sno") int no,@RequestParam("sname") String name) {
		System.out.println("TestController.readParams():: sno="+no+"     "+ "sname::"+name);
	  return "result";	
	}*/
	
	@GetMapping("/processurl")
	public String  readParams(@RequestParam(required = false) Integer sno,@RequestParam String sname,@RequestParam("sname") List<String>namesList) {
		System.out.println("TestController.readParams():: sno="+sno+"     "+ "sname::"+sname+" namesList"+namesList);
	  return "result";	
	}

}
