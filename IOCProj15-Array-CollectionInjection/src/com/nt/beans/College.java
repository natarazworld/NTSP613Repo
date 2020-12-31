package com.nt.beans;

import java.util.Arrays;
import java.util.Date;

public class College {
	private String favStudents[];
	private  Date  impDates[];
	
	public void setFavStudents(String[] favStudents) {
		this.favStudents = favStudents;
	}
	public void setImpDates(Date[] impDates) {
		this.impDates = impDates;
	}
	
	@Override
	public String toString() {
		return "College [favStudents=" + Arrays.toString(favStudents) + ", impDates=" + Arrays.toString(impDates) + "]";
	}

}//class
