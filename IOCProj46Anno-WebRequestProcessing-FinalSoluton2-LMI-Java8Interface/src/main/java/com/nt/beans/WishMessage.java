package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("wm")
public class WishMessage {
	
	private WishMessage() {
		System.out.println("WishMessage.0-param private constructor");
	}
	
	public  String  showWishMsg(String user) {
		return "Good Morning::"+user;
	}

}
