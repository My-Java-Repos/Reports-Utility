package com.org.datacore.reports.clinical.model;

import java.util.Date;

public class PatientGapsInfo {

	private int id;
	private String hcc;
	private String icc;
	private Date refDate;
	
	public String getHcc() {
		return hcc;
	}
	public void setHcc(String hcc) {
		this.hcc = hcc;
	}
	public String getIcc() {
		return icc;
	}
	public void setIcc(String icc) {
		this.icc = icc;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRefDate() {
		return refDate;
	}
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}
	public PatientGapsInfo(int id, String hcc, String icc, Date refDate) {
		super();
		this.id = id;
		this.hcc = hcc;
		this.icc = icc;
		this.refDate = refDate;
	}
	
	public PatientGapsInfo() {
		
	}
}
