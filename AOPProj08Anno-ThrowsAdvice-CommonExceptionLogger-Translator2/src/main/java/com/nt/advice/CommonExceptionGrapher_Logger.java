package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InternalProblemException;

@Component("expLogger")
@Aspect
public class CommonExceptionGrapher_Logger {

	@AfterThrowing(value="execution(double  com.nt.service.ShoppingStore.calc*(..))",throwing = "iae")
	public  void    exceptionLogger(JoinPoint jp,IllegalArgumentException iae)throws Throwable {
		//common  exception logging
		Writer writer=new FileWriter("e:/expLogger.txt",true);
		writer.write(jp.getSignature()+" with args"+Arrays.toString(jp.getArgs())+" has rasied exception "+iae+" \n");
		writer.flush();
		writer.close();
		//Exception transalation/Graphing
		throw new  InternalProblemException(jp.getSignature()+" with args"+Arrays.toString(jp.getArgs())+" has rasied exception ");
		
		
	}
	
}
