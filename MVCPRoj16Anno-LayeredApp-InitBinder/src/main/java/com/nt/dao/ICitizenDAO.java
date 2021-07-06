package com.nt.dao;

import java.util.List;

import com.nt.model.CitizenDetails;

public interface ICitizenDAO {
    public  int  insert(CitizenDetails details);
    public  List<String>  getAllVaccineNames();
}
