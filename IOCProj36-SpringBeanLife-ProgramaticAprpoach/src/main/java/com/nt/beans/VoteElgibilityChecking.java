//VoteElgibilityChecking.java
package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Setter;
public class VoteElgibilityChecking  implements InitializingBean,DisposableBean {
    //@Setter	
	private String name;
    //@Setter
	private  int age;
	private  Date  verificationDate;
	
    public VoteElgibilityChecking() {
		System.out.println("VoteElgibilityChecking.0-param constructor");
	}
    
	public void setName(String name) {
		System.out.println("VoteElgibilityChecking.setName(-)");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VoteElgibilityChecking.setAge(-)");
		this.age = age;
	}



	//init life cycle method (custom init method)
	public void  afterPropertiesSet() {
		System.out.println("VoteElgibilityChecking.afterPropertiesSet()");
		//initialize those properties which are not partcipating in the injections
		 verificationDate=new Date();
		 // check wheather imp porperties are injected with correct values or not
		 if(name==null || name.equals("")||  age<=0 || age>=125)  //validation logic
			  throw new IllegalArgumentException("invalid inputs");
	}
	
	
	//b.method
	public  String  checkElgibility() {
		System.out.println("VoteElgibilityChecking.checkElgibility()");
		if(age<18)
			 return "Mr./Miss./Mrs."+name +"("+age+") u r not elgible for Voting  . Verified on "+verificationDate;
		else
			 return "Mr./Miss./Mrs."+name +"("+age+") u r  elgible  for voting  . Verified on "+verificationDate;
	}//method
	
    public void destroy() {
    	System.out.println("VoteElgibilityChecking.destroy()");
    	//nullify bean properties
    	 name=null;
    	 age=0;
    	 verificationDate=null;
    }//method

}//class
