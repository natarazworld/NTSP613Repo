package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("blic")
@PropertySource(value="com/nt/commons/info.properties")
public class BankLoanIntrestCalculator {
	@Value("${amt.details}")
	private  IntrestAmountDetails  details;

	
	public  float  calculateIntrestAmount() {
		return  (details.getPamt()*details.getRate()*details.getTime())/100.0f;
	}
	
	

}
