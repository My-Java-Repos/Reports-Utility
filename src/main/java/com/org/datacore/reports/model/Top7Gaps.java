package com.org.datacore.reports.model;

public class Top7Gaps {

	private String name;
	private String type;
	private int HCCCode;
	private int reCaptureCount;
	private int suspectCount;
	private int insufficientCount;
	private int cms_suspectCount;
	private int count;

	public int getReCaptureCount() {
		return reCaptureCount;
	}

	public void setReCaptureCount(int reCaptureCount) {
		this.reCaptureCount = reCaptureCount;
	}

	public int getSuspectCount() {
		return suspectCount;
	}

	public void setSuspectCount(int suspectCount) {
		this.suspectCount = suspectCount;
	}

	public int getInsufficientCount() {
		return insufficientCount;
	}

	public void setInsufficientCount(int insufficientCount) {
		this.insufficientCount = insufficientCount;
	}

	public int getCms_suspectCount() {
		return cms_suspectCount;
	}

	public void setCms_suspectCount(int cms_suspectCount) {
		this.cms_suspectCount = cms_suspectCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHCCCode() {
		return HCCCode;
	}

	public void setHCCCode(int hCCCode) {
		HCCCode = hCCCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Top7Gaps() {

	}

	public Top7Gaps(String name, String type, int hCCCode, int reCaptureCount, int suspectCount, int insufficientCount,
			int cms_suspectCount, int count) {
		super();
		this.name = name;
		this.type = type;
		HCCCode = hCCCode;
		this.reCaptureCount = reCaptureCount;
		this.suspectCount = suspectCount;
		this.insufficientCount = insufficientCount;
		this.cms_suspectCount = cms_suspectCount;
		this.count = count;
	}
	
}
