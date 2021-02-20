package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private Integer serialNo;
	private Integer  empNo;
	private String ename;
	private String job; 
	private  Float sal;
	private  Integer  deptNo;
}
