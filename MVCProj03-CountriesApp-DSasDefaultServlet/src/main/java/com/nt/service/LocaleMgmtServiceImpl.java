package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocaleMgmtServiceImpl implements ILocaleMgmtService {
	

	@Override
	public List<String> fetchAllCountries() {
	    //get All Locales of the world
		Locale locales[]=Locale.getAvailableLocales();
		List<String> listCountries=new ArrayList();
		for(Locale l:locales) {
			if(l!=null && l.getDisplayCountry().length()!=0)
				listCountries.add(l.getDisplayCountry());
		}
		return listCountries;
	}

}
