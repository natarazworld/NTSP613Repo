package com.nt.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBO {
  private int empNo;
  private String ename;
  private String job;
  private float sal;
}
