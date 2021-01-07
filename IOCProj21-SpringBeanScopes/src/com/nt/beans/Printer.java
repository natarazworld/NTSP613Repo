//Printer.java (Singleton java class with minumun standards)
package com.nt.beans;

public class Printer {
	 //static reference variable
	private static Printer INSTANCE;  
	//private constructor
	private Printer() {
		System.out.println("Printer:: 0-param constructor");
	}//constructor
	
	//public static factory method having singleton logic
	public  static   Printer  getInstance() {
		 if(INSTANCE==null)
			 INSTANCE=new Printer();
		 return INSTANCE;
	}//method
	
	//b.method
	public   void printData(String msg) {
		System.out.println(msg);
	}

}//class
