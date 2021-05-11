package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class TestDrivingAuditAdvice {
	
	public void testDriving(JoinPoint jp)throws Throwable{
		System.out.println("TestDrivingAuditAdvice.testDriving()");
		Object args[]=jp.getArgs();
		String auditLogMsg=args[0]+" customer  has come for testing driving of "+args[1]+" model car on  "+new Date();
		Writer writer =new FileWriter("e:\\testdrive_audit.txt",true);  //audit log file..
		writer.write(auditLogMsg+"\n");
		writer.flush();
		writer.close();
	}

}
