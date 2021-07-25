package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeePaginationController {
	
  @Autowired
  private IEmployeeMgmtService service ;	
  
  @GetMapping("/")
  public  String  showHomePage() {
	   return "page_form";
  }
	
 @RequestMapping(value="/report",method = {RequestMethod.GET,RequestMethod.POST})
	public  String  fetchPageData(@PageableDefault(page = 0,size = 3,sort = "ename",direction = Direction.ASC)Pageable pageable,
			                                            Map<String,Object> map,HttpServletRequest req ) {
	 //keep  pageSize in Session scope
	 HttpSession ses=req.getSession(true);
	 if(req.getParameter("size")==null || req.getParameter("size").equals("") || req.getParameter("size").length()==0)
	       ses.setAttribute("psize",3);
	 else
		  ses.setAttribute("psize",Integer.parseInt(req.getParameter("size")));
	 
	  //use service
	  Page<Employee> page=service.getPageData(pageable);
	  //keep the results in model attributes
	  map.put("pageData", page);
	  
	  //return LVN
	  return "employee_report";
		
		
	}


}
