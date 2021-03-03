//WishMessageGeneartor
package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGeneartor {
	//@Autowired
	private LocalDateTime date;
	
	public WishMessageGeneartor() {
		System.out.println("WishMessageGeneartor:: 0-param constructor");
	}
	
	public  String  geneateWishMessage(String user) {
		int hour=0;
		System.out.println("WishMessageGeneartor:: geneateWishMessage()");
		//get curent hour of the day
		hour=date.getHour();  //24 hours format
		//geneate wish Message
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good AfterNoon::"+user;
		else if(hour<20)
			return "Good Eveing::"+user;
		else
			return "Good Night::"+user;
	}

}
