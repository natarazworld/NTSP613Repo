//Vehicle.java (taget class)
package com.nt.comps;

public final class Vehicle {
	private IEngine engg;  //HAS-A property /composition
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}

	public Vehicle() {
		System.out.println("Vehicle:: 0-param construtor");
	}
	
	public Vehicle(IEngine engg) {
		this.engg=engg;
		System.out.println("Vehicle::1-param construtor");
	}
	
	
		public  void setEngg(IEngine engg) {
			System.out.println("Vehicle.setEngg(-)");
			this.engg=engg;
		}
		
	public    void journey(String sourcePlace , String destPlace) {
		engg.start();
		System.out.println("Jounery started at::"+sourcePlace);
		System.out.println("Jouney is going on ......... in"+type);
		engg.stop();
		System.out.println("Jounery ended at::"+destPlace);
	}
	

}
