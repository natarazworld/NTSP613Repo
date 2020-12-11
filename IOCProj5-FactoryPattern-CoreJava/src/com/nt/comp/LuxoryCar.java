//LuxoryCar.java
package com.nt.comp;

public class LuxoryCar implements ICar  {

	@Override
	public void drive() {
		System.out.println("Driving Luxory Car....");
		
	}

	@Override
	public void addAccessories() {
		System.out.println("Fitting Accessories to Luxory Car....");
	}

}
