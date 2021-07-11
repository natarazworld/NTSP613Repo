package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoronaVaccine {
	private Integer regNo;
	private String name;
	private String company;
	private  String country;
	private  double price;

}
