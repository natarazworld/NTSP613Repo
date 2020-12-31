package com.nt.beans;

import java.util.Date;
import java.util.List;

public class Student {
   private  List<Integer> marks;
   private   List<Date> impDates;
   
public void setMarks(List<Integer> marks) {
	this.marks = marks;
}
public void setImpDates(List<Date> impDates) {
	this.impDates = impDates;
}
@Override
public String toString() {
	return "Student [marks=" + marks + ", impDates=" + impDates + "]-->"+marks.getClass();
}


   
}
