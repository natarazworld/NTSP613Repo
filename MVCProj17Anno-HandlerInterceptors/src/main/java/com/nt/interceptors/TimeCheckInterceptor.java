package com.nt.interceptors;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("tci")
public class TimeCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeCheckInterceptor.preHandle()");
	if(request.getServletPath().equalsIgnoreCase("/list_countries")) {
	     //check the timings
		// get current hour of the day
		 LocalDateTime  ldt=LocalDateTime.now(); //gives system date and time
		 int hour=ldt.getHour();//24 hours format
		 if(hour<9 || hour>=17) {
			  RequestDispatcher rd=request.getRequestDispatcher("/timeout.jsp");
			  rd.forward(request, response);
			  return false;
		 }
	}//if
		 return true;
	
		 
	}

}
