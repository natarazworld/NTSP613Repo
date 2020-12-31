package com.nt.beans;

import java.util.Properties;

public class CourseInfo {
    private  Properties  courseDetails;

	public CourseInfo(Properties courseDetails) {
		this.courseDetails = courseDetails;
	}

	@Override
	public String toString() {
		return "CourseInfo [courseDetails=" + courseDetails + "]";
	}
	
	
    
}
