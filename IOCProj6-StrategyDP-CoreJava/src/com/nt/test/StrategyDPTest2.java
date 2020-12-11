package com.nt.test;

import com.nt.comps.Vehicle;
import com.nt.factory.VehicleFactory;

public class StrategyDPTest2 {

	public static void main(String[] args) {
		try {
		// get Vehicle object (target class obj)
		Vehicle vehicle=VehicleFactory.getInstance("cng");
		 //invoke b.method
		vehicle.journey("hyd", "goa");
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		

	}

}
