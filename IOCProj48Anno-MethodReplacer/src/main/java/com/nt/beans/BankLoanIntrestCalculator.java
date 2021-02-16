// BankLoanIntrestCalculator.java (main class)
package com.nt.beans;


public class BankLoanIntrestCalculator {

	public   float  calculateIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankLoanIntrestCalculator::calculateIntrestAmount(-,-,-) (compound Intrest)");
		//Amount = P (1 + r/100)^t -p
		return   (float) (pAmt*Math.pow((1+(rate/100)),time))-pAmt;
	}
	
	
}
