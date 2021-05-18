package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("cacheAdvice")
@Aspect

public class AroundCaching_PerformenceMonitoringAdvice {
   private Map<String,Object> cacheMap=new HashMap();
   
   @Pointcut(value = "execution(double  com.nt.service.BankService.calc*(..))")
   public  void  myPtc() {
   }
   
   @Around(value = "myPtc()")
   @Order(10)
	public   Object caching(ProceedingJoinPoint pjp)throws Throwable{
		//prepare key
		String key=pjp.getSignature()+Arrays.deepToString(pjp.getArgs());
		Object retVal=null;
		//check in cache
		if(!cacheMap.containsKey(key)) {
		retVal=pjp.proceed();  //invoke the target method
		 cacheMap.put(key, retVal);  //put results in cache
		 System.out.println("from target method");
		}
		else {
			retVal=cacheMap.get(key);  //gather results from cache
			System.out.println("from cache");
		}
		return retVal;
	}
   
   @Around(value = "myPtc()")
   @Order(20)
	public Object  performence(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("PerformenceMonitoringAdvice.performence() (before entring ...)");
		//pre logic
		long start=System.currentTimeMillis();
		
		//modifying target method arg values
		Object args[]=pjp.getArgs();
		if(((double)args[0])<50000)
			args[1]=(Double)args[1]-0.5;
		//controling target method execution
		if((double)args[0]<=0 ||(double)args[1]<=0 ||(double)args[2]<=0)
			throw new IllegalArgumentException("invalid inputs");
		 Object retVal=pjp.proceed(args); //calls target method
		 
		 //post logic
		long end=System.currentTimeMillis();
		
		System.out.println("PerformenceMonitoringAdvice.performence() (after  exiting ...)");
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken"+(end-start)+" ms.");
		//modifying return value
		retVal=(double)retVal+ (double)retVal*0.1;
		return retVal;
	}
}
