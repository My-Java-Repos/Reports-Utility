package com.org.datacore.reports;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.org.datacore.reports.controller.MetricsReportController;
import com.org.datacore.reports.model.MetricsReport;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.service.MetricsReportService;
import com.org.datacore.reports.util.RequestValidator;

@ExtendWith(MockitoExtension.class)
public class MetricsReportControllerTest {

	@InjectMocks
	MetricsReportController controller;

	@Mock
	MetricsReportService service;

	@Mock
	RequestValidator validator;

	@Mock
	Model model;

	@Test
	public void homePage() {

		assertEquals("index", controller.homePage(model));
	}

	@Test
	public void getMetricsReportTest() {
		ReportInput reportInput = new ReportInput();
		when(validator.validateRequest(reportInput)).thenReturn(true);
		MetricsReport metricsReport = new MetricsReport();
		
		when(service.getMetricsReport(reportInput)).thenReturn(metricsReport);

		when(service.generateExcelFile(metricsReport, reportInput)).thenReturn("path");

		assertEquals("index", controller.getMetricsReport(model, reportInput));
	}

	@Test
	public void getMetricsReportWhenValidationFail() {
		ReportInput reportInput = new ReportInput();
		when(validator.validateRequest(reportInput)).thenReturn(false);

		assertEquals("index", controller.getMetricsReport(model, reportInput));
	}

	@Test
	public void getMetricsReportWhenExceptionOccuer() {
		ReportInput reportInput = new ReportInput();
		
		when(validator.validateRequest(reportInput)).thenThrow(new RuntimeException());

		assertEquals("error", controller.getMetricsReport(model, reportInput));
	}

	@Test
	public void getMetricsReportWhenFileCreationFail() {
		ReportInput reportInput = new ReportInput();
		when(validator.validateRequest(reportInput)).thenReturn(true);
		MetricsReport metricsReport = new MetricsReport();
		when(service.getMetricsReport(reportInput)).thenReturn(metricsReport);

		when(service.generateExcelFile(metricsReport, reportInput)).thenReturn("");

		assertEquals("index", controller.getMetricsReport(model, reportInput));
	}
}
