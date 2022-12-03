package com.org.datacore.reports.service;

import com.org.datacore.reports.clinical.model.ClinicalChartReport;
import com.org.datacore.reports.model.MetricsReport;
import com.org.datacore.reports.model.ReportInput;

public interface MetricsReportService {

	MetricsReport getMetricsReport(ReportInput reportInput);

	String generateExcelFile(MetricsReport mr, ReportInput reportInput);

	ClinicalChartReport getclinicalChartReport(ReportInput reportInput);

	String generateClinicalChartReportExcelFile(ClinicalChartReport clinicalReport, ReportInput reportInput);

}
