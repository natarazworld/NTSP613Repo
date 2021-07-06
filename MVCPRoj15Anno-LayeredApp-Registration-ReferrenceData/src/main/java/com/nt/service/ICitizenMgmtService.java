package com.nt.service;

import java.util.List;
import java.util.Set;

import com.nt.model.CitizenDetails;

public interface ICitizenMgmtService {
    public  String   vaccineRegistration(CitizenDetails details) ;
    public  List<String> fetchAllVaccines();
    public  Set<String> getAllCountries();
    public  Set<String> getAllLanguages();
    public  Set<String> getAllHobies();
    public  Set<String> getStatesOfACountry(String country);
    
}
