//SportsCar.java
package com.nt.comp;

public class SportsCar implements ICar  {

	@Override
	public void drive() {
		System.out.println("Driving Sports Car....");
		
	}

	@Override
	public void addAccessories() {
		System.out.println("Fitting Accessories to Sports Car....");
	}

}
