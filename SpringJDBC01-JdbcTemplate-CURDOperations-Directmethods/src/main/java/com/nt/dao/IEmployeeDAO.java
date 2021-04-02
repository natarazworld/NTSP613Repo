//IEmployeeDAO.java
package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeDAO {
    public  int  getEmployeesCount();
    public  Float getEmployeeSalaryByEno(int eno);
    public  Map<String,Object> getEmployeeDetailsByEno(int eno);
    public List<Map<String,Object>> getEmployeeDetailsByDesgs(String desg1,String desg2,String desg3);
    public SqlRowSet  getEmployeeDetailsBySalaryRange(float startSalary,float endSalary);
}
