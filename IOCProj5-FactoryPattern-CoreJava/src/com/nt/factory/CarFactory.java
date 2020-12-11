package com.nt.factory;

import com.nt.comp.BudgetCar;
import com.nt.comp.ICar;
import com.nt.comp.LuxoryCar;
import com.nt.comp.SportsCar;

public class CarFactory {

	  //factory method -- having factory pattern  logic
	public   static ICar  getInstance(String type) {
		ICar car=null;
		  if(type.equalsIgnoreCase("luxory")) 
			  car=new LuxoryCar();
		  else if(type.equals("budget"))
			   car=new BudgetCar();
		  else if(type.equalsIgnoreCase("sports"))
			   car=new SportsCar();
		  else
			  throw new IllegalArgumentException("invalid car type");
		  
		  return car;
		  
	}
	
}
