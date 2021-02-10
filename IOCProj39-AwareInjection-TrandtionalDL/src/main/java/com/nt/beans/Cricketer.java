//Cricketer.java (target class)
package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer  implements  ApplicationContextAware {
	private String name;
	private int jersyNo;
	private String beanId;  //To just CricketBat obj bean id 
	private  ApplicationContext ctx;
	
	public void setBeanId(String beanId) {
		System.out.println("Cricketer.setBeanId()");
		this.beanId = beanId;
	}
	
	@Override   //  It is not setter method for setter Injection .It is method ApplicationContextAware(I)
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext(-)"+ctx.getClass());
		 this.ctx=ctx;
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
		        System.out.println("2nd IOC container");
		        CricketBat bat=ctx.getBean(beanId,CricketBat.class);  //Dependency lookup
        //use CricketBat object
		        int score=bat.scoreRuns();
		        System.out.println("Criketer runs are  ::"+score);
	}//method

	

}//class
