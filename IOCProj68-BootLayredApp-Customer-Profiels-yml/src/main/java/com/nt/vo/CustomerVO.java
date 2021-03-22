package com.nt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {
	private String cname;
	private String cadd;
	private String pAmt;
	private String rate;
	private String time;

}
