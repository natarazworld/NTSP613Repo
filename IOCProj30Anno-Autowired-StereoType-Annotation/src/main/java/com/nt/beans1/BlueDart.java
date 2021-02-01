//BlueDart.java
package com.nt.beans1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("courier")  //equal to  @Component(value="courier")
@Scope("prototype")  //equal to  @Scope(value="prototype")
public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering(BlueDart) products  having   "+oid +"order id";
	}

}
