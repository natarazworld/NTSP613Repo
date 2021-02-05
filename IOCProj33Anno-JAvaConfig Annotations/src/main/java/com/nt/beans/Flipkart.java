package com.nt.beans;

import java.util.Arrays;
//Flipkart.java
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.beans1.Courier;

@Named("fpkt")  // To cfg java class as spring bean
public class Flipkart {
	/*@Inject
	@Named("activeCourier") */
	private Courier courier;
	
	/*@Named("activeCourier")
	@Inject
	public void setCourier(Courier courier) {
		this.courier=courier;
	}*/
	
	/*	@Named("activeCourier")
		@Inject
		public void insert(Courier courier) {
			this.courier=courier;
		}*/
	
	@Named("activeCourier")
	//@Inject
	@Autowired(required = true)
	public Flipkart(Courier courier) {
		this.courier=courier;
	}
	
	
	public Flipkart() {
		System.out.println("Flipkart :: 0-param constructor");
	}
	
	//b,method
	public  String shopping(String items[],float prices[]) {
		float billAmt=0.0f;
		for(float p:prices)
			billAmt=billAmt+p;
		//generate order id
		int oid=new Random().nextInt(10000);
		//use courier
		String msg=courier.deliver(oid);
	    String finalMsg=Arrays.toString(items)+"are shopped having prices"+Arrays.toString(prices)+" with bill Amt::"+billAmt+"--->"+msg;
		return finalMsg;
	}

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier +"]";
	}

	
	
	

}
