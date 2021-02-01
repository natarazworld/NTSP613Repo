//FirstFlight.java
package com.nt.beans1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fFlight")
@Scope("prototype")
public class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(FirstFlight) products  having "+oid +"order id";
	}

}
