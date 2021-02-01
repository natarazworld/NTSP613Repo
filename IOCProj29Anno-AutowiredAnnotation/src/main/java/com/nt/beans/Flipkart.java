package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
//Flipkart.java
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Flipkart {
	
	@Autowired(required=true)
	//@Qualifier("dtdc")
	private Courier courier;
	
	/*@Autowired(required =true)
	public Flipkart(@Qualifier("dhl") Courier cr) {
	  System.out.println("Flipkart:: 1-param constructor(courier)");
		this.courier = cr;
	}*/
	
	
	
	//@Autowired
	//@Qualifier("fFlight")
	public  void  setCourier(Courier cr) {
		System.out.println("Flipkart.setCourier()");
		this.courier=cr;
	}
	
	/*@Autowired
	@Qualifier("bDart")
	public  void  assign(Courier cr) {
		System.out.println("Flipkart.assign(-)");
		this.courier=cr;
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
