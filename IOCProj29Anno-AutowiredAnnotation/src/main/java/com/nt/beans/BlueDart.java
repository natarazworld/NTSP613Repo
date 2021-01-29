//BlueDart.java
package com.nt.beans;

public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(BlueDart) products  having   "+oid +"order id";
	}

}
