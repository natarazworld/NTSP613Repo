package com.nt.test;

import com.nt.comps.Vehicle;
import com.nt.factory.VehicleFactory;

public class StrategyDPTest1 {

	public static void main(String[] args) {
		try {
		// get Vehicle object (target class obj)
		Vehicle vehicle=VehicleFactory.getInstance("diesel");
		 //invoke b.method
		vehicle.journey("hyd", "delhi");
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		

	}

}
