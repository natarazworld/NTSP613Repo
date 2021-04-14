package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationAOImpl implements IAuthenticationDAO {
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String autheticate(String user, String pwd) {
		//set PL/SQL procedure name 
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare Map of In param namea and values
		Map<String,Object> inParams=Map.of("USER",user,"PASS",pwd);  // key1,value1,key2,val2
		//execute /call PL/SQL procedure
		Map<String,Object> outParams=sjc.execute(inParams);
		//gather results
		return (String)outParams.get("RESULT");
	}

}
