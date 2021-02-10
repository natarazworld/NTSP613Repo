//Cricketer.java (target class)
package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("cricketer")
public class Cricketer  implements  ApplicationContextAware {
	@Value("${cktr.name}")
	private String name;
	@Value("${cktr.jersyNo}")
	private int jersyNo;
	@Value("${ckbat.id}")
	private String beanId;  //To just CricketBat obj bean id 
	private  ApplicationContext ctx;
	
	
	
	@Override   //  It is not setter method for setter Injection .It is method ApplicationContextAware(I)
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext(-)"+ctx.getClass());
		 this.ctx=ctx;
	}

	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor");
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
