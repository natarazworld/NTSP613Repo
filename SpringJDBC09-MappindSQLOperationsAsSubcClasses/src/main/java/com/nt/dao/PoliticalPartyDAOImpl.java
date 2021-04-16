package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.nt.model.PoliticalParty;

@Repository("partyDAO")
public class PoliticalPartyDAOImpl implements IPoliticalPartyDAO {
     private  static final String GET_PARTY_DETAILS_BY_ID="SELECT PARTYID,PARTYNAME,FLAGCOLORS,PARTYSYMBOL FROM POLITICALPARTY  WHERE PARTYID=?";
     private  static final String GET_PARTY_DETAILS_BY_NAMES="SELECT PARTYID,PARTYNAME,FLAGCOLORS,PARTYSYMBOL FROM POLITICALPARTY  WHERE PARTYNAME IN(?,?,?)";
	 
     private  PoliticalPartySelector1  selector1;
     private  PoliticalPartySelector2  selector2;
	  
     @Autowired
	public PoliticalPartyDAOImpl(DataSource ds) {
         selector1=new PoliticalPartySelector1(ds, GET_PARTY_DETAILS_BY_ID);
         selector2=new PoliticalPartySelector2(ds,GET_PARTY_DETAILS_BY_NAMES);
	  }

	@Override
	public PoliticalParty getPoliticalPartyDetailsByPartyId(int partyId) {
		 PoliticalParty  party=selector1.findObject(partyId);
		 return party;
	}
	
	@Override
	public List<PoliticalParty> getPoliticalPartiesByPartyNames(String partyName1, String partyName2,	String partyName3) {
		  List<PoliticalParty> list=selector2.execute(partyName1,partyName2,partyName3);
		return list;
	}
	
	//========================================================================
	
	//inner class cum sub class1
	   private static class PoliticalPartySelector1 extends MappingSqlQuery<PoliticalParty>{
		   
		   public PoliticalPartySelector1(DataSource ds, String query) {
			    super(ds,query);
			    super.declareParameter(new SqlParameter(Types.INTEGER));
			    super.compile();
		   }
		   

		@Override
		public PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
		    //copy RS object to  Model class obj
			 PoliticalParty  party=new PoliticalParty();
			 party.setPartyId(rs.getInt(1));
			 party.setPartyName(rs.getString(2));
			 party.setFlagColors(rs.getString(3));
			 party.setPartySymbol(rs.getString(4));
			return party;
		}
		   
	   }//method
	   
	   //inner class cum sub class1
	   private static class PoliticalPartySelector2 extends MappingSqlQuery<PoliticalParty>{
		   
		   public PoliticalPartySelector2(DataSource ds, String query) {
			    super(ds,query);
			    super.declareParameter(new SqlParameter(Types.VARCHAR));
			    super.declareParameter(new SqlParameter(Types.VARCHAR));
			    super.declareParameter(new SqlParameter(Types.VARCHAR));
			    super.compile();
		   }
		   
			@Override
			public PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			    //copy RS object to  Model class obj
				 PoliticalParty  party=new PoliticalParty();
				 party.setPartyId(rs.getInt(1));
				 party.setPartyName(rs.getString(2));
				 party.setFlagColors(rs.getString(3));
				 party.setPartySymbol(rs.getString(4));
				return party;
			}
	   }


}//class
