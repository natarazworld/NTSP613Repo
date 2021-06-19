package com.nt.model;

import lombok.Data;

@Data
public class Student {
	private Integer sno=100;
	private String sname="rakesh";
	private Float avg=11.11f;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}
}
