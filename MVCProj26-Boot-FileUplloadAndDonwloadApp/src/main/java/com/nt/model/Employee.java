package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Employee {
	 private int eno;
	private String ename;
	private String addrs;
	private  MultipartFile resume;
	private  MultipartFile photo;
	private  String resumeFileLocation;
	private  String photoFileLocation;

}
