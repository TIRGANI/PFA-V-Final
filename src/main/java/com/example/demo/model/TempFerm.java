package com.example.demo.model;

import java.util.Date;

public class TempFerm {
	private int fermid;
	private Float temp;
	private Date date;

	public TempFerm(int fermid, Float temp, Date date) {
		super();
		this.fermid = fermid;
		this.temp = temp;
		this.date = date;
	}

	public TempFerm() {

	}

	public int getFermid() {
		return fermid;
	}

	public void setFermid(int fermid) {
		this.fermid = fermid;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
