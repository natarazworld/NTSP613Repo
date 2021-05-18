package com.nt.service;

import org.springframework.stereotype.Service;

@Service("store")
public class ShoppingStore {
	
	public   double  calcBillAmount(double price, double qty) {
		System.out.println("ShoppingStore.calcBillAmount()");
		   if(price<=0.0 || qty<=0.0f)
			   throw new  IllegalArgumentException("Invalid   price and qty");
		   //calculate billAmount
		   double billAmt=price*qty;
		   return billAmt;
	}
	

}
