//FacultyInfo.java
package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class FacultyInfo {
	private  Set<Long>  phoneNumbers;
	private  Set<Date> impDates;

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public void setImpDates(Set<Date> impDates) {
		this.impDates = impDates;
	}
	
	@Override
	public String toString() {
		return "FacultyInfo [phoneNumbers=" + phoneNumbers + ", impDates=" + impDates + "]-->"+phoneNumbers.getClass();
	}

}//class
