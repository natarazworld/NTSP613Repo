package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IPoliticalPartyDAO;
import com.nt.model.PoliticalParty;

@Service("partyService")
public class PoliticalPartyMgmtServiceImpl implements IPoliticalPartyMgmtService {
	@Autowired
	private  IPoliticalPartyDAO  dao;

	@Override
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(int partyId) {
		//use dao
		PoliticalParty party=dao.getPoliticalPartyDetailsByPartyId(partyId);
		return party;
	}

	@Override
	public List<PoliticalParty> fetchPoliticalPartiesDetailsByPartyNames(String partyName1, String partyName2,
			String partyName3) {
		  //use DAO
		List<PoliticalParty> list=dao.getPoliticalPartiesByPartyNames(partyName1, partyName2, partyName3);
		return list;
	}

	@Override
	public String modifyFlagColorsByPartyName(String newColors, String partyName) {
		//use DAO
		int count=dao.updateFlagColorsByPartyName(partyName, newColors);
		return count==0?"Party Not found":"PartyFound and flag colors are updated";
	}

}
