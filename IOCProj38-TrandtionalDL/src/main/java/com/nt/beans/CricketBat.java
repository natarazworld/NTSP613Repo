//CricketBat.java (Depedent class)
package com.nt.beans;

import java.util.Random;

public class CricketBat {
	
	public CricketBat() {
		System.out.println("CricketBat:: 0-param constructor");
	}
	
	public   int scoreRuns() {
		System.out.println("CricketBat.scoreRuns()");
		return new Random().nextInt(100);
	}

}
