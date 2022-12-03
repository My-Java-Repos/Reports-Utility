package com.org.datacore.reports.model;

public class SourceType {

	private String name;
	private String type;
	private String sourceType;
	private int count;

	public SourceType(String name, String type, String sourceType, int count) {
		super();
		this.name = name;
		this.type = type;
		this.sourceType = sourceType;
		this.count = count;
	}

	public SourceType() {

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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

}
