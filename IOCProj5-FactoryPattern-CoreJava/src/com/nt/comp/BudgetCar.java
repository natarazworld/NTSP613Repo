//BudgetCar.java
package com.nt.comp;

public class BudgetCar implements ICar  {

	@Override
	public void drive() {
		System.out.println("Driving Budget Car....");
	}
	@Override
	public void addAccessories() {
		System.out.println("Fitting Accessories to Budget Car....");
	}
}
