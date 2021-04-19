package com.nt.service;

import java.util.List;

import com.nt.model.PoliticalParty;

public interface IPoliticalPartyMgmtService {
     public PoliticalParty  fetchPoliticalPartyDetailsByPartyId(int partyId);
     public List<PoliticalParty>  fetchPoliticalPartiesDetailsByPartyNames(String partyName1,String patyName2,String partyName3);
     public String modifyFlagColorsByPartyName(String newColors,String partyName);
}
