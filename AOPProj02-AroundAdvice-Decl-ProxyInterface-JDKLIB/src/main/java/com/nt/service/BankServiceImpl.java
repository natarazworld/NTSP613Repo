//BankService.java
package com.nt.service;

public    class BankServiceImpl implements IBankService{
     public  final  double calcSimpleIntrestAmount(double pAmt,double rate,double time) {
    	 System.out.println("BankService.calcSimpleIntrestAmount()"+pAmt+"   "+rate+"  "+time);
    	 return (pAmt*rate*time)/100.0f;
     }
     
     public final  double calcCompoundIntrestAmount(double pAmt,double rate,double time) {
    	 System.out.println("BankService.calcCompoundIntrestAmount()"+pAmt+"   "+rate+"  "+time);
    	   return   (pAmt*Math.pow(1+rate/100,time))-pAmt;
     }
     
}
