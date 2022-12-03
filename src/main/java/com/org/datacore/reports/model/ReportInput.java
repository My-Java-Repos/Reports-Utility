package com.org.datacore.reports.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReportInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
	
	private String name;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReportInput(Date startDate, Date endDate, String name) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
	}
	
	public ReportInput() {
		
	}
}
