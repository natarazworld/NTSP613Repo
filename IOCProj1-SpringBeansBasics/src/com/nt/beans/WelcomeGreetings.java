// WelcomeGreetings.java ( User-defined java class as spring bean)
package com.nt.beans;

public class WelcomeGreetings {
	
	static {
		System.out.println("WelcomeGreetings.static block");
	}
	
	public WelcomeGreetings() {
		System.out.println("WelcomeGreetings: 0-param constructor");
	}
	
	public String welcome(String user) {
		return "welcome to String::"+user;
	}

}
