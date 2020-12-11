///DieselEngine.java
package com.nt.comps;

public final class DieselEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("DieselEngine.start()::-->Diesel Engine started");

	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()::-->Diesel Engine stopped");

	}

}
