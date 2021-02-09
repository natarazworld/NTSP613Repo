//Cricketer.java (target class)
package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer {
	private String name;
	private int jersyNo;
	private String beanId;  //To just CricketBat obj bean id 
	
	public void setBeanId(String beanId) {
		System.out.println("Cricketer.setBeanId()");
		this.beanId = beanId;
	}

	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor");
	}
  
	public void setName(String name) {
		System.out.println("Cricketer.setName()");
		this.name = name;
	}

	public void setJersyNo(int jersyNo) {
		System.out.println("Cricketer.setJersyNo()");
		this.jersyNo = jersyNo;
	}

	public  void  bowling() {
		System.out.println("Mr."+name+" having jersyNo:"+jersyNo+" is bowling");
	}
	
	public void fielding() {
		System.out.println("Mr."+name+" having jersyNo:"+jersyNo+" is fielding");
	}
	
	public void batting() {
		System.out.println("Mr."+name+" having jersyNo:"+jersyNo+" is battting");
		//DependencyLookup  to get CricketBat object  only in the batting method
		     //create  an extra IOC container
		        ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		        System.out.println("2nd IOC container");
		        CricketBat bat=ctx.getBean(beanId,CricketBat.class);  //Dependency lookup
        //use CricketBat object
		        int score=bat.scoreRuns();
		        System.out.println("Criketer runs are  ::"+score);
	}//method

}//class
