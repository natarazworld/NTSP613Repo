package com.nt.listener;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


public class IOCContainerMonitoringListener  implements ApplicationListener {
    private long start,end;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
	    if(event.toString().contains("RefreshedEvent")) { 
	    	System.out.println("ApplicationContext -IOC container is started at::"+new Date()); 
	    	start=System.currentTimeMillis();  //gives currentTime in Millis  with respect to jan  epoach 1st 1970 Midnight 00:00 hrs
	    	 
	    }
	    else  if(event.toString().contains("ClosedEvent")) {
	    	System.out.println("ApplicationContext -IOC container is stopped at::"+new Date()); 
	    	 end=System.currentTimeMillis();
	    	 System.out.println("The ApplicationContext container is in running mode for ::"+(end-start)+" ms");
	    }
	    
	}//method
}//class
