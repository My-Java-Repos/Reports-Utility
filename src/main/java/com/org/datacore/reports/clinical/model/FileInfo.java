package com.org.datacore.reports.clinical.model;

import java.util.Date;

public class FileInfo {

	private int id;
	private String fileName;
	private String personID;
	private Date updateDtm;
	private Date createDtm;
	private String state;
	
	public FileInfo(int id, String fileName, String personID, Date updateDtm, Date createDtm, String state) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.personID = personID;
		this.updateDtm = updateDtm;
		this.createDtm = createDtm;
		this.state = state;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public Date getUpdateDtm() {
		return updateDtm;
	}
	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}
	public Date getCreateDtm() {
		return createDtm;
	}
	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
