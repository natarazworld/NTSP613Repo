package com.nt.external;

public class ICCScoreCompImpl implements IICCScoreComp {

	@Override
	public String getScore(int mid) {
		if(mid==1001)
		     return "IND vs PAK ::  300/4 (Ind) ";
		else if(mid==1002)
			 return "AUS vs ENG ::  260/4 (ENG) ";
		else if(mid==1003)
			return "WI vs NZ ::  300/4 (WI) ";
		else
			throw new IllegalArgumentException("Invalid Match Id");
	}

}
