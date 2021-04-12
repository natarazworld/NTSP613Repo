package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IActorDAO;
import com.nt.model.ActorDetails;

@Service("actorService")
public class ActorMgmtSeviceImpl implements IActorMgmtService {
	@Autowired
	private IActorDAO dao;

	@Override
	public String registerActor(ActorDetails details) {
         //use DAO
		int count=dao.insert(details);
		return count==0?"Registration failed":"Registration succeded";
	}

}
