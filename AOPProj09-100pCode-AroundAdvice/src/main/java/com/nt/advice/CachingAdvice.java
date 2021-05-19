package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("cacheAdvice")
@Aspect
@Order(1)
public class CachingAdvice {
   private Map<String,Object> cacheMap=new HashMap();
   
   @Around(value = "execution(double  com.nt.service.BankService.calc*(..))")
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
}
