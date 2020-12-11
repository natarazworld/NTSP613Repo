//WishMessageGeneator.java (Target class) 
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	//bean property/atttribute
  private  Date date;   //after injection  it holds sys date and time
  
  static {
	  System.out.println("WishMessageGenerator:: static block");
  }
  
  
  
 public void setDate(Date date) {
	 System.out.println("WishMessageGenerator.setDate(-)");
	this.date = date;
}


 public WishMessageGenerator() {
	System.out.println("WishMessageGenerator.WishMessageGenerator()");
}

public WishMessageGenerator(Date date) {
	System.out.println("WishMessageGenerator:: 1-param constructor");
	this.date=date;
  }

  
  
//  b.method
public  String generateWishMessage(String user) {
	System.out.println("WishMessageGenerator.generateWishMessage()-->"+date);
	 //get hour of the day
	 int hour=date.getHours(); // 24 hours format
	 //generate wish Message
	  if(hour<12)
		   return "Good Morning::"+user;
	  else if(hour<16)
		  return "Good AfterNoon::"+user;
	  else if(hour<20)
		  return "Good Evening::"+user;
	  else
		  return "Good Night::"+user;
}
  
}
