package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private String cname;
	private String cadd;
	private float pAmt;
	private float rate;
	private float time;

	// getters && setters (alt+shift+s ,r)
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public float getpAmt() {
		return pAmt;
	}

	public void setpAmt(float pAmt) {
		this.pAmt = pAmt;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	// toString()  -- alt+shift+s,s
	@Override
	public String toString() {
		return "CustomerDTO [cname=" + cname + ", cadd=" + cadd + ", pAmt=" + pAmt + ", rate=" + rate + ", time=" + time
				+ "]";
	}

}
