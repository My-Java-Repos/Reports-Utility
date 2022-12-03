package com.org.datacore.reports.model;

import java.util.Date;

public class PatientProvider {

	private String npi;
	private String updatedUserFN;
	private String updatedUserLN;
	private String updatedUserRole;
	private String type;
	private String name;
	private Date updateDtm;
	private Date createDtm;
	private String createdUserFN;
	private String createdUserLN;
	private String patientFN;
	private String patientLN;
	private String memberId;
	
	
	public String getNpi() {
		return npi;
	}
	public void setNpi(String npi) {
		this.npi = npi;
	}
	public String getUpdatedUserFN() {
		return updatedUserFN;
	}
	public void setUpdatedUserFN(String updatedUserFN) {
		this.updatedUserFN = updatedUserFN;
	}
	public String getUpdatedUserLN() {
		return updatedUserLN;
	}
	public void setUpdatedUserLN(String updatedUserLN) {
		this.updatedUserLN = updatedUserLN;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCreatedUserFN() {
		return createdUserFN;
	}
	public void setCreatedUserFN(String createdUserFN) {
		this.createdUserFN = createdUserFN;
	}
	public String getCreatedUserLN() {
		return createdUserLN;
	}
	public void setCreatedUserLN(String createdUserLN) {
		this.createdUserLN = createdUserLN;
	}
	public String getPatientFN() {
		return patientFN;
	}
	public void setPatientFN(String patientFN) {
		this.patientFN = patientFN;
	}
	public String getPatientLN() {
		return patientLN;
	}
	public void setPatientLN(String patientLN) {
		this.patientLN = patientLN;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public PatientProvider(String npi, String updatedUserFN, String updatedUserLN,String updatedUserRole, String type, String name,
			Date updateDtm, Date createDtm, String createdUserFN, String createdUserLN, String patientFN,
			String patientLN, String memberId) {
		super();
		this.npi = npi;
		this.updatedUserFN = updatedUserFN;
		this.updatedUserLN = updatedUserLN;
		this.updatedUserRole = updatedUserRole;
		this.type = type;
		this.name = name;
		this.updateDtm = updateDtm;
		this.createDtm = createDtm;
		this.createdUserFN = createdUserFN;
		this.createdUserLN = createdUserLN;
		this.patientFN = patientFN;
		this.patientLN = patientLN;
		this.memberId = memberId;
	}
	
	public PatientProvider() {
		
	}
	public String getUpdatedUserRole() {
		return updatedUserRole;
	}
	public void setUpdatedUserRole(String updatedUserRole) {
		this.updatedUserRole = updatedUserRole;
	}
	
}
