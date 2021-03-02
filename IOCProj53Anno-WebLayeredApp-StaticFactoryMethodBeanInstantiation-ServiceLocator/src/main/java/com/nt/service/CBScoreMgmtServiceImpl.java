package com.nt.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.external.IICCScoreComp;

@Service("cbService")
public class CBScoreMgmtServiceImpl implements ICBScoreMgmtService {
	@Autowired
	private  IICCScoreComp  extComp;

	@Override
	public String findScore(int mid) {
		//use exstenal comp
		String score=extComp.getScore(mid);
		return score;
	}

}
