///DieselEngine.java
package com.nt.comps;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DieselEngine implements IEngine {
	
	public DieselEngine() {
		System.out.println("DieselEngine:: 0-param costructor");
	}

	@Override
	public void start() {
		System.out.println("DieselEngine.start()::-->Diesel Engine started");

	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()::-->Diesel Engine stopped");

	}

}
