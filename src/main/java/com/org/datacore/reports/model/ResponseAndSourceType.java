package com.org.datacore.reports.model;

public class ResponseAndSourceType {

	private String name;
	private String type;
	private String responseType;
	private String sourceType;
	private int count;

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

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ResponseAndSourceType(String name, String type, String responseType, String sourceType, int count) {
		super();
		this.name = name;
		this.type = type;
		this.responseType = responseType;
		this.sourceType = sourceType;
		this.count = count;
	}

	public ResponseAndSourceType() {

	}
}
