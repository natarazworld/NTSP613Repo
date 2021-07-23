package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TilesController {
	
	@GetMapping("/")
	public  String  showHomePage() {
		 //return   tile definitation name as the  LVN
		return "homePageDef";
	}
	
	@GetMapping("/cinema")
	public  String  showCinemaPage() {
		 //return   tile definitation name as the  LVN
		return "cinemaPageDef";
	}
	
	@GetMapping("/politics")
	public  String  showPoliticsPage() {
		 //return   tile definitation name as the  LVN
		return "politicsPageDef";
	}
	
	@GetMapping("/sports")
	public  String  showSportsPage() {
		 //return   tile definitation name as the  LVN
		return "sportsPageDef";
	}
	
	@GetMapping("/about")
	public  String  showAboutUsPage() {
		 //return   physical jsp file name as   LVN
		return "about_us";
	}



}
