package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("per")
@ToString
public class Person {
	@Value("${per.id}")
	private int pid;
	@Value("rajesh")
	private String pname;
	@Value("34.77f")
	private  float age;

}
