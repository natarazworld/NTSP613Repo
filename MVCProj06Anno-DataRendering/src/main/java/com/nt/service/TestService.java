package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nt.dto.StudentDTO;

public interface TestService {
     public   String getData1();
     public   int[] getData2();
     public   List<String> getData3();
     public   Set<Long> getData4();
     public  Map<String,Object> getData5();
     public  List<StudentDTO>  getData6();
     
     
}
