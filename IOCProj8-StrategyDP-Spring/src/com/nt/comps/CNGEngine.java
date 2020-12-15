///CNGEngine.java
package com.nt.comps;

public final class CNGEngine implements IEngine {
	
	public CNGEngine() {
		System.out.println("CNGEngine::0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine.start()::-->CNG Engine started");

	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop()::-->CNG Engine stopped");

	}

}
