package com.org.datacore.reports.clinical.model;

import java.util.Date;

public class ClinicalChart {

	private String fileName;
	private String subscriberID;
	private String gmpi;
	private String firstName;
	private String lastName;
	private Date dob;
	private Date dos;
	private Date submittedDate;
	private String entity;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getGmpi() {
		return gmpi;
	}

	public void setGmpi(String gmpi) {
		this.gmpi = gmpi;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDos() {
		return dos;
	}

	public void setDos(Date dos) {
		this.dos = dos;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

}
