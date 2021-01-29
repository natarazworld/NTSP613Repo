//DHL.java
package com.nt.beans;

public class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(DHL) products  having   "+oid +"order id";
	}

}
