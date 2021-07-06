package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.CitizenDetails;

@Repository("citizenDAO")
public class CitizenDAOImpl implements ICitizenDAO {
	private static final String  VACCINE_REGISTRATION_QUERY="INSERT INTO CORONA_VACCINE1 VALUES(REGID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	private static final String  GET_ALL_VACCINES="SELECT  NAME FROM CORONA_VACCINE";
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

	@Override
	public List<String> getAllVaccineNames() {
	    List<String>  vaccinesList=jt.query(GET_ALL_VACCINES,rs->{
	    	 List<String> vaccsList=new ArrayList();
	    	 while(rs.next()) {
	    		 vaccsList.add(rs.getString(1));
	    	 }
	    	 return vaccsList;
	    });
		return  vaccinesList;
	}//method

}//class
