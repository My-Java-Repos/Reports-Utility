package com.org.datacore.reports.clinical.model;

import java.util.List;

public class ClinicalChartReport {

	private List<ClinicalChart> clinicalCharts;

	public List<ClinicalChart> getClinicalCharts() {
		return clinicalCharts;
	}

	public void setClinicalCharts(List<ClinicalChart> clinicalCharts) {
		this.clinicalCharts = clinicalCharts;
	}
}
