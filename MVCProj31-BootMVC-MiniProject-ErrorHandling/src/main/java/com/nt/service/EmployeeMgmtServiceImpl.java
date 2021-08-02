package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo   empRepo;

	@Override
	public Iterable<Employee> fetchAllEmps() {
	  //use Repo
		Iterable<Employee> listEmps=empRepo.findAll();
		return listEmps;
	}

	@Override
	public Employee fetchEmployeeById(int eno) {
		//use Repo
		Optional<Employee> opt=empRepo.findById(eno);
		Employee emp=opt.get();
		if(opt.isPresent())
			return opt.get();
		else
			throw  new  EmployeeNotFoundException(eno+"  id employee is not found");
			
	}

	@Override
	public String modifyEmployeeById(Employee emp) {
	  //use Repo
		Employee emp1=empRepo.findById(emp.getEmpno()).get();
		if(emp1!=null) {
			empRepo.save(emp1);		
		     return "Employee Updated ";
		}
		else {
			return "Employee not updated";
		}

	}//method

	@Override
	public String fireEmployeeByNo(int eno) {
		//use Repo
		if(empRepo.findById(eno).get()!=null) {
		  empRepo.deleteById(eno);
		  return "Employee Deleted";
		}
		  else
			  return "Employee is not deleted";
	}//method

}//class
