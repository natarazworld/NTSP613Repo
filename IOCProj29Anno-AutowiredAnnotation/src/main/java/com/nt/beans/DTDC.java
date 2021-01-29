//DTDC.java
package com.nt.beans;

public class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(DTDC) products  having "+oid +"order id";
	}

}
