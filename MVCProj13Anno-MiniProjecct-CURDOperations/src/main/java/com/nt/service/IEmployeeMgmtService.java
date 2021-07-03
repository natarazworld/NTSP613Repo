package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
    public  List<Employee>  fetchAllEmps();
    public  Employee   fetchEmployeeById(int eno);
    public  String  modifyEmployeeById(Employee emp);
    public  String  fireEmployeeByNo(int eno);
}
