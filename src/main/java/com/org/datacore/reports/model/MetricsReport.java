package com.org.datacore.reports.model;

import java.util.List;

public class MetricsReport {

	private List<UniqueUser> uniqueUsers;
	private List<UniqueProvider> uniqueProviders;
	private List<UniqueMember> uniqueMembers;
	private List<SourceType> sourceTypes;
	private List<ResponseType> responseTypes;
	private List<TotalResponseType> totalResponseTypes;
	private List<ResponseAndSourceType> responseAndSourceTypes;
	private List<Top7Gaps> top7Gaps;
	private List<PatientProvider> patientProviders;

	public List<UniqueUser> getUniqueUsers() {
		return uniqueUsers;
	}

	public void setUniqueUsers(List<UniqueUser> uniqueUsers) {
		if (this.uniqueUsers != null) {
			this.uniqueUsers.addAll(uniqueUsers);
		} else {
			this.uniqueUsers = uniqueUsers;
		}

	}

	public List<UniqueProvider> getUniqueProviders() {
		return uniqueProviders;
	}

	public void setUniqueProviders(List<UniqueProvider> uniqueProviders) {
		if (this.uniqueProviders != null) {
			this.uniqueProviders.addAll(uniqueProviders);
		} else {
			this.uniqueProviders = uniqueProviders;
		}

	}

	public List<UniqueMember> getUniqueMembers() {
		return uniqueMembers;
	}

	public void setUniqueMembers(List<UniqueMember> uniqueMembers) {
		if (this.uniqueMembers != null) {
			this.uniqueMembers.addAll(uniqueMembers);
		} else {
			this.uniqueMembers = uniqueMembers;
		}

	}

	public List<SourceType> getSourceTypes() {
		return sourceTypes;
	}

	public void setSourceTypes(List<SourceType> sourceTypes) {
		if (this.sourceTypes != null) {
			this.sourceTypes.addAll(sourceTypes);
		} else {
			this.sourceTypes = sourceTypes;
		}

	}

	public List<ResponseType> getResponseTypes() {
		return responseTypes;
	}

	public void setResponseTypes(List<ResponseType> responseTypes) {
		if (this.responseTypes != null) {
			this.responseTypes.addAll(responseTypes);
		} else {
			this.responseTypes = responseTypes;
		}

	}

	public List<TotalResponseType> getTotalResponseTypes() {
		return totalResponseTypes;
	}

	public void setTotalResponseTypes(List<TotalResponseType> totalResponseTypes) {
		if (this.totalResponseTypes != null) {
			this.totalResponseTypes.addAll(totalResponseTypes);
		} else {
			this.totalResponseTypes = totalResponseTypes;
		}

	}

	public List<ResponseAndSourceType> getResponseAndSourceTypes() {
		return responseAndSourceTypes;
	}

	public void setResponseAndSourceTypes(List<ResponseAndSourceType> responseAndSourceTypes) {
		if (this.responseAndSourceTypes != null) {
			this.responseAndSourceTypes.addAll(responseAndSourceTypes);
		} else {
			this.responseAndSourceTypes = responseAndSourceTypes;
		}

	}

	public List<Top7Gaps> getTop7Gaps() {
		return top7Gaps;
	}

	public void setTop7Gaps(List<Top7Gaps> top7Gaps) {
		if (this.top7Gaps != null) {
			this.top7Gaps.addAll(top7Gaps);
		} else {
			this.top7Gaps = top7Gaps;
		}

	}

	public List<PatientProvider> getPatientProviders() {
		return patientProviders;
	}

	public void setPatientProviders(List<PatientProvider> patientProviders) {
		if (this.patientProviders != null) {
			this.patientProviders.addAll(patientProviders);
		} else {
			this.patientProviders = patientProviders;
		}
	}

}
