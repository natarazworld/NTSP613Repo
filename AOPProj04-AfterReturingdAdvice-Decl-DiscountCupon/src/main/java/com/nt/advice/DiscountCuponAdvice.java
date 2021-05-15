package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponAdvice {

	/*	public   void    generateCupon(JoinPoint  jp, double billAmt)throws  Throwable{
			System.out.println("DiscountCuponAdvice.generateCupon()");
			String cuponMsg=null;
			if(billAmt>=50000)
				  cuponMsg="Avail  30%  discount  on next purchase";
			else if(billAmt>=30000)
				cuponMsg="Avail  15%  discount  on next purchase";
			else 
				cuponMsg="Avail  5%  discount  on next purchase";
			//generate the cupon
			Writer writer =new FileWriter("e:\\cupon.txt");
			writer.write(cuponMsg);
			writer.flush();
			writer.close();
		}
	*/	
	
	public   void    generateCupon( double billAmt)throws  Throwable{
		System.out.println("DiscountCuponAdvice.generateCupon()");
		String cuponMsg=null;
		if(billAmt>=50000)
			  cuponMsg="Avail  30%  discount  on next purchase";
		else if(billAmt>=30000)
			cuponMsg="Avail  15%  discount  on next purchase";
		else 
			cuponMsg="Avail  5%  discount  on next purchase";
		//generate the cupon
		Writer writer =new FileWriter("e:\\cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		
	}
}
