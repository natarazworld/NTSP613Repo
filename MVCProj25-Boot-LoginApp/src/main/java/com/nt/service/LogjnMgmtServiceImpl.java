package com.nt.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dao.ILoginDAO;

@Service("loginSerivce")
public class LogjnMgmtServiceImpl implements ILogjnManagementService {
	@Autowired
	private ILoginDAO dao;

	@Override
	public String doLogin(String user, String pwd) {
         //use service
		String result=dao.authenticate(user, pwd);
		return result;
	}

}
