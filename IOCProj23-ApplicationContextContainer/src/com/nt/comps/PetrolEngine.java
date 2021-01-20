//PertrolEngine.java
package com.nt.comps;

public final class PetrolEngine implements IEngine {

	public PetrolEngine() {
		System.out.println("PetrolEngine: 0-param constructor");
	}
	
	@Override
	public void start() {
		System.out.println("PetrolEngine.start()::-->Petrol Engine started");

	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()::-->Pertrol Engine stopped");

	}

}
