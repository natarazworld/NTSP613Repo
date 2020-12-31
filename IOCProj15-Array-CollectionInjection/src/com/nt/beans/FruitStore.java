//FruitStore.java
package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FruitStore {
   private  Map<String,Float> fruitsInfo;
   private  Map<String,Date>  impDates;

   public FruitStore(Map<String, Float> fruitsInfo, Map<String, Date> impDates) {
	this.fruitsInfo = fruitsInfo;
	this.impDates = impDates;
}

@Override
public String toString() {
	return "FruitStore [fruitsInfo=" + fruitsInfo + ", impDates=" + impDates + "]-->"+fruitsInfo.getClass();
}
}
