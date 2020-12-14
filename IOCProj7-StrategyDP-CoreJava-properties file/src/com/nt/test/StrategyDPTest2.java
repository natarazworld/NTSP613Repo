package com.nt.test;

import com.nt.comps.Vehicle;
import com.nt.factory.VehicleFactory;

public class StrategyDPTest2 {

	public static void main(String[] args) {
		// get Vehicle object (target class obj)
		Vehicle vehicle=VehicleFactory.getInstance();
		 //invoke b.method
		vehicle.journey("hyd", "goa");
	}
}
