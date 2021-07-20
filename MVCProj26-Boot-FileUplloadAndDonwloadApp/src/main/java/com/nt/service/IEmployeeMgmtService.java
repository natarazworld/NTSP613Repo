package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
     public   String   uploadFiles(String destPath, Employee emp)throws Exception;
     public  List<String>  getAllFiles(String destPath)throws Exception;
}
