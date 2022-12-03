package com.org.datacore.reports.clinical.model;

import java.util.Comparator;
import java.util.Date;

public class PatientInfo {

	private String entity;
	private String personID;
	private String firstName;
	private String lastNAme;
	private Date dob;
	private Date dos;
	private String hccCode;
	private String iccCode;
	private String status;
	private Date updateTime;
	private Date refDate;

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastNAme;
	}

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Date getDos() {
		return dos;
	}

	public void setDos(Date dos) {
		this.dos = dos;
	}

	public PatientInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getHccCode() {
		return hccCode;
	}

	public void setHccCode(String hccCode) {
		this.hccCode = hccCode;
	}

	public String getIccCode() {
		return iccCode;
	}

	public void setIccCode(String iccCode) {
		this.iccCode = iccCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public PatientInfo(String entity, String personID, String firstName, String lastNAme, Date dob, Date dos,
			String hccCode, String iccCode, String status, Date updateTime, Date refDate) {
		super();
		this.entity = entity;
		this.personID = personID;
		this.firstName = firstName;
		this.lastNAme = lastNAme;
		this.dob = dob;
		this.dos = dos;
		this.hccCode = hccCode;
		this.iccCode = iccCode;
		this.status = status;
		this.updateTime = updateTime;
		this.refDate = refDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((dos == null) ? 0 : dos.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hccCode == null) ? 0 : hccCode.hashCode());
		result = prime * result + ((iccCode == null) ? 0 : iccCode.hashCode());
		result = prime * result + ((lastNAme == null) ? 0 : lastNAme.hashCode());
		result = prime * result + ((personID == null) ? 0 : personID.hashCode());
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientInfo other = (PatientInfo) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (dos == null) {
			if (other.dos != null)
				return false;
		} else if (!dos.equals(other.dos))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hccCode == null) {
			if (other.hccCode != null)
				return false;
		} else if (!hccCode.equals(other.hccCode))
			return false;
		if (iccCode == null) {
			if (other.iccCode != null)
				return false;
		} else if (!iccCode.equals(other.iccCode))
			return false;
		if (lastNAme == null) {
			if (other.lastNAme != null)
				return false;
		} else if (!lastNAme.equals(other.lastNAme))
			return false;
		if (personID == null) {
			if (other.personID != null)
				return false;
		} else if (!personID.equals(other.personID))
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatientInfo [entity=" + entity + ", personID=" + personID + ", firstName=" + firstName + ", lastNAme="
				+ lastNAme + ", dob=" + dob + ", dos=" + dos + ", hccCode=" + hccCode + ", iccCode=" + iccCode
				+ ", status=" + status + ", updateTime=" + updateTime + ", refDate=" + refDate + "]";
	}

}
