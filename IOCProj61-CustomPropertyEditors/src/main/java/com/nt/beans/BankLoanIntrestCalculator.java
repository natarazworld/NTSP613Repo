package com.nt.beans;

public class BankLoanIntrestCalculator {
	private  IntrestAmountDetails  details;

	public void setDetails(IntrestAmountDetails details) {
		this.details = details;
	}
	
	public  float  calculateIntrestAmount() {
		return  (details.getPamt()*details.getRate()*details.getTime())/100.0f;
	}
	
	

}
