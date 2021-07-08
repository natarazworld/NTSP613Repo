package com.nt.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private  IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/empReport")
	public String  generateReport(Map<String,Object> map){
		//use service
		List<Employee> listEmps=service.fetchAllEmps();
      //keep results in  model attribue
		  map.put("empsList",listEmps);
		  //return LVN
		  return "employee_report";
	}
	
	@GetMapping("/employee_edit")   // launches form page for edit operation having existing values as the initial values
	public String  showEmployee(@ModelAttribute("emp") Employee emp,@RequestParam("eno")Integer no) {
		//use service
		Employee e1=service.fetchEmployeeById(no);
		//copy to Model class obj
		BeanUtils.copyProperties(e1, emp);
		//return LVN
		return "employee_modify";
	}
	
	@PostMapping("/employee_edit")
	public   String  updateEmployee(Map<String,Object> map,@ModelAttribute("emp")Employee emp) {
		//use servie
		String updationMsg=service.modifyEmployeeById(emp);
		List<Employee> listEmps=service.fetchAllEmps();
		//keep result in model attribute
		map.put("resultMsg",updationMsg);
		map.put("empsList",listEmps);
		//retunr report page name as LVN
		return "employee_report";
		
	}
	
	@GetMapping("/employee_delete")
	public String  deleteEmployee(Map<String,Object> map, @RequestParam("delEno")  int[] enos) {
		//use  service
		String deleteMsg=service.fireEmployeesByNos(enos);
		List<Employee> listEmps=service.fetchAllEmps();
		//keep results in model attributes
		map.put("resultMsg",deleteMsg);
		map.put("empsList",listEmps);
		//retunr report page name as LVN
				return "employee_report";
	}
	
	/*	@PostMapping("/employee_edit")
		public   String  updateEmployee(RedirectAttributes rattrs,@ModelAttribute("emp")Employee emp) {
			//use servie
			String updationMsg=service.modifyEmployeeById(emp);
			//keep result in model attribute
			rattrs.addFlashAttribute("resultMsg",updationMsg);
			//retunr report page name as LVN
			return "redirect:empReport";
			}*/

}
