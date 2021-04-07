package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
    public  EmployeeDTO fetchEmployeeByNo(int eno);
    public  List<EmployeeDTO> fetchEmployeesByDesg(String desg1,String desg2,String desg3);
}
