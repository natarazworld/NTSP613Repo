//DTDC.java
package com.nt.beans1;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Primary
@Scope("prototype")
public class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(DTDC) products  having "+oid +"order id";
	}

}
