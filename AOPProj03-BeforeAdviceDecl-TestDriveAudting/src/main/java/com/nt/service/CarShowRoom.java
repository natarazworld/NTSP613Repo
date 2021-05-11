package com.nt.service;

public class CarShowRoom {

	public String  sellCar(String custName,String carModel,double price) {
		System.out.println("CarShowRoom.sellCar()");
		if(carModel.equalsIgnoreCase("beleano"))
			return "Car "+carModel +" is sold out at price ::"+price+" to customer ::"+custName;
		else
			return  "Car "+carModel +" is not avaiable for sale"; 
		
	}
}
