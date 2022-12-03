package com.org.datacore.reports.model;

public class ResponseType {

	private String name;
	private String type;
	private String responseType;
	private int count;

	public ResponseType(String name, String type, String responseType, int count) {
		super();
		this.name = name;
		this.type = type;
		this.responseType = responseType;
		this.count = count;
	}

	public ResponseType() {

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

}
