package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ICBScoreMgmtService;

@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;
	
	@Override
	public void init() throws ServletException {
	   //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get Local Service class object
		ICBScoreMgmtService service=ctx.getBean("cbService",ICBScoreMgmtService.class);
		// read match id as the request param value
		int mid=Integer.parseInt(req.getParameter("mid"));
		//invoke Local service class object
		String score=service.findScore(mid);
		//keep result in request scope
		req.setAttribute("scoreBoard", score);
		//forward to show_score.jsp page
		RequestDispatcher rd=req.getRequestDispatcher("/show_score.jsp");
		rd.forward(req, res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
	
	@Override
	public void destroy() {
	    ((AbstractApplicationContext) ctx).close();
	}
}//class
