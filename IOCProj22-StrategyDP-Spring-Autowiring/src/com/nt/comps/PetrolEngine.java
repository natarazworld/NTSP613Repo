//PertrolEngine.java
package com.nt.comps;

public final class PetrolEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("PetrolEngine.start()::-->Petrol Engine started");

	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()::-->Pertrol Engine stopped");

	}

}
