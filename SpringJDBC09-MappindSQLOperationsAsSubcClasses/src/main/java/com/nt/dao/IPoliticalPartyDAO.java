package com.nt.dao;

import java.util.List;

import com.nt.model.PoliticalParty;

public interface IPoliticalPartyDAO {
     public  PoliticalParty  getPoliticalPartyDetailsByPartyId(int partyId);
     public List<PoliticalParty> getPoliticalPartiesByPartyNames(String partyName1,String partyName2,String partyName3);
}
