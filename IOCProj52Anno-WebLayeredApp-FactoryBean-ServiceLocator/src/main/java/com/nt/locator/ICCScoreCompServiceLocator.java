package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import com.nt.external.ICCScoreCompImpl;
import com.nt.external.IICCScoreComp;

@Component("iccLocator")
public class ICCScoreCompServiceLocator  implements FactoryBean<IICCScoreComp> {

	@Override
	public IICCScoreComp getObject() throws Exception {
		//Actually we should jndi look code getting Extenal Comp ref.. since we take Extenal Comp 
		//normal java class for simplification , So we are going to create object for that class directly
		 IICCScoreComp  comp=new ICCScoreCompImpl();
		return comp;
	}

	@Override
	public Class<?> getObjectType() {
			return IICCScoreComp.class;
	}
	
	@Override
	public boolean isSingleton() {
	  return true;
	}

}
