package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
        public List<Employee> getAllEmployees();
        public  Employee getEmployeeByEno(int eno);
        public  int  updateEmployeeByEno(Employee emp);
        public  int  deleteEmployeeByEno(int eno);
}
