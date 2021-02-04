package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;

//@Service("custService")
@Component("custService")
public final class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	//@Qualifier("oracleCustDAO")
	@Qualifier("selectedDAO")
	private  ICustomerDAO dao;
	

	@Override
	public String calculateSimpleIntrestAmount(CustomerDTO dto) throws Exception {
		//write b.logic to calculate simple intrAmount  based on  pAmt,rate,time
		float intrAmt=(dto.getPAmt()*dto.getRate()*dto.getTime())/100.0f;
		//prepare  CustomerBO obj having persistable data
		CustomerBO bo=new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setPamt(dto.getPAmt());
		bo.setTime(dto.getTime());
		bo.setRate(dto.getRate());
		bo.setIntrAmt(intrAmt);
         //use DAO		
		int count=dao.insert(bo);
		   // immeridate if or ternary operator  <cond>?<success>:<failuare>
		return count==0?"Customer Registration failed":"Customer Registration Succeded:: Details are :: principlet amount::"+dto.getPAmt()+"Time:: "+dto.getTime()+" rate::"+dto.getRate()+" Intrest amount:: "+intrAmt;
	}
    
}
