package com.nt.beans;

import java.util.Arrays;
//Flipkart.java
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Named;

import com.nt.beans1.Courier;

@Named("fpkt")  // To cfg java class as spring bean
public class Flipkart {
		//@Resource(name="dhl")
		@Resource(name="activeCourier")
	private Courier courier;
	
	/*@Resource(name="activeCourier")
	public void setCourier(Courier courier) {
		this.courier=courier;
	}*/
	
	/*	@Resource("activeCourier")
		public void insert(Courier courier) {
			this.courier=courier;
		}*/
	
	
	
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
