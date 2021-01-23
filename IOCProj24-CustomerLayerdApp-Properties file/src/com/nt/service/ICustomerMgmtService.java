package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerMgmtService {
	public  String   calculateSimpleIntrestAmount(CustomerDTO dto)throws Exception;
}
