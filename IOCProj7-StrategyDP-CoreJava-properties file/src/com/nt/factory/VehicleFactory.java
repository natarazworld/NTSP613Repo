package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nt.comps.IEngine;
import com.nt.comps.Vehicle;

public class VehicleFactory {
	private static Properties  props;
	static {
		try {
			//Load Proeprties file by Using InputSteam
			InputStream is=new FileInputStream("src/com/nt/commons/strategy.properties");
			//Load properties info to java.util.Properties class obj
			props=new Properties();
			props.load(is);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  Vehicle  getInstance() {
		Vehicle vehicle=null; 
		try {
		   //Load and create object of Dependent class by collecting class name from properties file
		   String dependentClassName=props.getProperty("dependent.className");
		   Class dependentClazz=Class.forName(dependentClassName);
		   //IEngine engg=(IEngine) dependentClazz.newInstance();  //neweInstance() method of java.lang.Class is depreated. 
		   Constructor cons[]=dependentClazz.getDeclaredConstructors();
		   IEngine engg=(IEngine)cons[0].newInstance();
		   //create object for target class (fixed)
		   vehicle=new Vehicle();
		   //assign Dependent class obj to target class obj
		   vehicle.setEngg(engg);
		 }//try
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return  vehicle;
	}//factory method

}//class
