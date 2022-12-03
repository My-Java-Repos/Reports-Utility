package com.org.datacore.reports.clinical.model;

import java.util.Comparator;

public class PatientsSortByDOS implements Comparator<PatientInfo>{

	@Override
	public int compare(PatientInfo o1, PatientInfo o2) {
		// TODO Auto-generated method stub
		return o2.getDos().compareTo(o1.getDos());
	}
	
}