package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformenceMonitoringAdvice {
	
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
