//CarCustomer.java
package com.nt.test;

import com.nt.comp.ICar;
import com.nt.factory.CarFactory;

public class CarCustomer {

	public static void main(String[] args) {
		
		//get Car 
		ICar car=CarFactory.getInstance("sports");
		System.out.println(car.getClass());
		car.drive();
		car.addAccessories();

	}

}
