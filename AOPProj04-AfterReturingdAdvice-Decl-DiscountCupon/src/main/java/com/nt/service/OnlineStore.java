package com.nt.service;

public class OnlineStore {

	
	public   double   shopping(String items[],double prices[]) {
		System.out.println("OnlineStore.shopping(-,-)");
		
		//calculate bill amount.
		double billAmt=0.0;
		for(double p:prices) {
			billAmt=billAmt+p;
		}
		return billAmt;
	}
	
}
