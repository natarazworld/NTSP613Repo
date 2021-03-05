package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import com.nt.external.ICCScoreCompImpl;
import com.nt.external.IICCScoreComp;

@Component("locator")
public class ICCScoreCompServiceLocator{

	public static  IICCScoreComp getExternalServiceComp(){
		//Actually we should write jndi lookup code for getting Extenal Comp ref.. since we have take External Comp 
		//as the normal java class for simplification , So we are going to create object for that class directly
		 IICCScoreComp  comp=new ICCScoreCompImpl();
		return comp;
	}


}
