package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.CitizenDetails;

@Repository("citizenDAO")
public class CitizenDAOImpl implements ICitizenDAO {
	private static final String  VACCINE_REGISTRATION_QUERY="INSERT INTO CORONA_VACCINE VALUES(REGID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(CitizenDetails details) {
		   int count=jt.update(VACCINE_REGISTRATION_QUERY,details.getName(),
				                                                                                       details.getAddrs(),
				                                                                                       details.getAadharNo(),
				                                                                                       details.getPrice(),
				                                                                                       details.getIncome(),
				                                                                                       details.getVaccineName(),
				                                                                                       details.getRemarks());
		   
		return count;
	}//method

}//class
