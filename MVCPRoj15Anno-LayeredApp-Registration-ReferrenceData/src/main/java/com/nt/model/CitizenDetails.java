//CitizenDetails.java
package com.nt.model;

import lombok.Data;

@Data
public class CitizenDetails {
	private Integer regId;
	private String name;
	private String addrs;
	private  Long aadharNo;
	private  Double price;
	private  String vaccineName;
	private  Double  income;
	private String remarks;
	private  String vflag="no";
	private  String  country="India";
	private  String  state;
	private String  languages[]=new String[]{"Hindi","English"};
	private String  hobies[]=new String[]{"surfing","Travelling"};

}
