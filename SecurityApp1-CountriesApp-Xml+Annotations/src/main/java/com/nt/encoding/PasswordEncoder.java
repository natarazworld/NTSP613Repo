package com.nt.encoding;

import java.beans.Encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder coder=new BCryptPasswordEncoder();
		
		 System.out.println(coder.encode("rani"));
		 System.out.println(coder.encode("hyd"));
		 System.out.println(coder.encode("delhi"));
		

	}

}
