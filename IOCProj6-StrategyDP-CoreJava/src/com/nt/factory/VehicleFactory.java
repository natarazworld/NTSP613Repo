package com.nt.factory;

import com.nt.comps.CNGEngine;
import com.nt.comps.DieselEngine;
import com.nt.comps.IEngine;
import com.nt.comps.PetrolEngine;
import com.nt.comps.Vehicle;

public class VehicleFactory {
	
	public static  Vehicle  getInstance(String engineType) {
		IEngine engg=null;
		//create Dependent class object
		 if(engineType.equalsIgnoreCase("diesel"))
			  engg=new DieselEngine();
		 else if(engineType.equalsIgnoreCase("petrol"))
			 engg=new PetrolEngine();
		 else if(engineType.equalsIgnoreCase("cng"))
			 engg=new CNGEngine();
		 else 
			 throw new IllegalArgumentException("invalid engine type");
		 //create Target class obj
		   Vehicle vehicle=new Vehicle();
		   //assign Dependent object to target obj
		   vehicle.setEngg(engg);
		   return vehicle;
	}

}
