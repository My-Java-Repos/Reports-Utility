package com.org.datacore.reports.model;

public class UniqueProvider {

	private String name;
	private String type;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public UniqueProvider(String name, String type, int count) {
		super();
		this.name = name;
		this.type = type;
		this.count = count;
	}
	
	public UniqueProvider() {
		
	}
	
}
