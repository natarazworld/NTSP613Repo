package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceTest2 {

	public static void main(String[] args) throws Exception{
		//Load  class
		Class c=Class.forName(args[0]);
		//get all declared constructor of Loaded class
         Constructor cons[]=c.getDeclaredConstructors();
         //create object using 0-param constructor
          Object obj1=cons[1].newInstance();
          System.out.println("obj1 data::"+obj1);
          System.out.println("------------------------");
          //create object using 0-param constructor
          Object obj2=cons[0].newInstance(10,20);
          System.out.println("obj2 data::"+obj2);
	}//main
}//class
