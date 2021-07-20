package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {
	@Autowired
    private SimpleJdbcCall sjc;	

	@Override
	public String authenticate(String user, String pwd) {
          // In Params Map obj
		Map<String,Object> inParams=Map.of("UNAME",user,"PWD",pwd);
		//call PL/SQL procedure
		sjc.setProcedureName("P_AUTHENTICATION");
		Map<String ,Object> outParams=sjc.execute(inParams);
		return (String)outParams.get("RESULT");
	}

}
