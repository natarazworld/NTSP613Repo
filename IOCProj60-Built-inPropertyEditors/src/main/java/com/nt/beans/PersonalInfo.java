package com.nt.beans;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import lombok.Setter;
import lombok.ToString;


@Setter
//@ToString
public class PersonalInfo {
	
	private  String name;
	private  float  age;
	private  int luckyNumber;
	//private  Date   doj;
	private  String[] moles;
	private  byte[]  academicPercentages;
	private  long adhaarNo;
	private  char  favChar;
	private  File   fileLocation;
	private Locale   favLocale;
	private  URL     fbUrl;
	private  Class   favClass;
	private Properties props;
	ResourceBundle bundle;
	private  Date  dom;
	
	
	
	@Override
	public String toString() {
		return "PersonalInfo [name=" + name + ", age=" + age + ", luckyNumber=" + luckyNumber 
				+ ", moles=" + Arrays.toString(moles) + ", academicPercentages=" + Arrays.toString(academicPercentages)
				+ ", adhaarNo=" + adhaarNo + ", favChar=" + favChar + ", fileLocation=" + fileLocation + ", favLocale="
				+ favLocale + ", fbUrl=" + fbUrl + ", favClass=" + favClass + ", props=" + props + ", bundle=" + bundle.getString("driverClass")
				+ "]"+", dom=" +dom;
	}
	
	
	
	
	

}
