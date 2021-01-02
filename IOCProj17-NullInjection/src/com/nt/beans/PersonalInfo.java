//PersonalInfo.java
package com.nt.beans;

import java.util.Date;

public class PersonalInfo {
	private String pname;
	private String paddrs;
	private  Date  dob;
	private  Date  doj;
	private  Date  dom;
	
	public PersonalInfo(String pname, String paddrs, Date dob, Date doj, Date dom) {
		System.out.println("PersonalInfo:: 5-param constructor");
		this.pname = pname;
		this.paddrs = paddrs;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}
	
	
	
	

}
