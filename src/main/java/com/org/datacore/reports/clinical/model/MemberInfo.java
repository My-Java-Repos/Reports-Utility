package com.org.datacore.reports.clinical.model;

import java.util.Date;

public class MemberInfo {

	private String personID;
	private String gmpi;
	private String subscriberID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String entity;

	public MemberInfo(String personID, String gmpi, String subscriberID, String firstName, String lastName, Date dob,
			String entity) {
		super();
		this.personID = personID;
		this.gmpi = gmpi;
		this.subscriberID = subscriberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.entity = entity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gmpi == null) ? 0 : gmpi.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((personID == null) ? 0 : personID.hashCode());
		result = prime * result + ((subscriberID == null) ? 0 : subscriberID.hashCode());
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
		MemberInfo other = (MemberInfo) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
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
		if (gmpi == null) {
			if (other.gmpi != null)
				return false;
		} else if (!gmpi.equals(other.gmpi))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (personID == null) {
			if (other.personID != null)
				return false;
		} else if (!personID.equals(other.personID))
			return false;
		if (subscriberID == null) {
			if (other.subscriberID != null)
				return false;
		} else if (!subscriberID.equals(other.subscriberID))
			return false;
		return true;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getGmpi() {
		return gmpi;
	}

	public void setGmpi(String gmpi) {
		this.gmpi = gmpi;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public MemberInfo() {

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

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

}
