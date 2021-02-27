package com.nt.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EletronicProduct extends Product {
	private String vottage;
	private String  starRating;

}
