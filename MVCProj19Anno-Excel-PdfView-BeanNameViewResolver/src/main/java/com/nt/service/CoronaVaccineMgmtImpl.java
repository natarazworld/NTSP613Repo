package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.model.CoronaVaccine;

@Service("vaccineService")
public class CoronaVaccineMgmtImpl  implements ICoronaVaccineMgmtService {
	
	@Override
	public List<CoronaVaccine> fetchAllVaccines() {
		return List.of(new CoronaVaccine(456,"covaxin", "BBT","india", 1000.0),
				              new CoronaVaccine(496,"covishield", "Serum","india", 2000.0),
				              new CoronaVaccine(296,"sputnik", "Rusie","Russia", 1000.0),
				              new CoronaVaccine(216,"pyzer", "pyzer","USA", 1200.0)
				               );
	}

}
