package com.example.TP1_OO.models;

import java.util.Date;

public class RentalRequest {
	private String personneTel;
	private Date begin;
	private Date end;

	public String getPersonneTel() {
		return personneTel;
	}
	public void setPersonneTel(String personneTel) {
		this.personneTel = personneTel;
	}

	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}