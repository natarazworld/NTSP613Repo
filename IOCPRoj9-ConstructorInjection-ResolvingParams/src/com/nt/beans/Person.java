package com.nt.beans;

public class Person {
  private int pid;
  private String name;
  private  long phone;
  
public Person(int pid, String name, long phone) {
	System.out.println("Person:: 3-param constructor");
	this.pid = pid;
	this.name = name;
	this.phone = phone;
}
@Override
public String toString() {
	return "Person [pid=" + pid + ", name=" + name + ", phone=" + phone + "]";
}


    
  
}
