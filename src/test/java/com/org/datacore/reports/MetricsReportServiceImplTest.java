package com.org.datacore.reports;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.org.datacore.reports.model.MetricsReport;
import com.org.datacore.reports.model.PatientProvider;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.model.ResponseAndSourceType;
import com.org.datacore.reports.model.ResponseType;
import com.org.datacore.reports.model.SourceType;
import com.org.datacore.reports.model.Top7Gaps;
import com.org.datacore.reports.model.TotalResponseType;
import com.org.datacore.reports.model.UniqueMember;
import com.org.datacore.reports.model.UniqueProvider;
import com.org.datacore.reports.model.UniqueUser;
import com.org.datacore.reports.repository.MetricsReportRepository;
import com.org.datacore.reports.services.impl.MetricsReportServiceImpl;
import com.org.datacore.reports.util.ExcelFileExporter;

@ExtendWith(MockitoExtension.class)
public class MetricsReportServiceImplTest {

	@InjectMocks
	MetricsReportServiceImpl service;

	@Mock
	MetricsReportRepository repository;

	@Mock
	ExcelFileExporter fileService;

	@Test
	public void getMetricsReportTest() {

		ReportInput reportInput = new ReportInput();

		when(repository.getUniqueUsers(reportInput)).thenReturn(new ArrayList<UniqueUser>());
		when(repository.getUniqueUsersNW(reportInput)).thenReturn(new ArrayList<UniqueUser>());
		when(repository.getUniqueProviders(reportInput)).thenReturn(new ArrayList<UniqueProvider>());
		when(repository.getUniqueProvidersNW(reportInput)).thenReturn(new ArrayList<UniqueProvider>());
		when(repository.getUniqueMembers(reportInput)).thenReturn(new ArrayList<UniqueMember>());
		when(repository.getUniqueMembersNW(reportInput)).thenReturn(new ArrayList<UniqueMember>());
		when(repository.getSourceTypes(reportInput)).thenReturn(new ArrayList<SourceType>());
		when(repository.getSourceTypesNW(reportInput)).thenReturn(new ArrayList<SourceType>());
		when(repository.getResponseTypes(reportInput)).thenReturn(new ArrayList<ResponseType>());
		when(repository.getResponseTypesNW(reportInput)).thenReturn(new ArrayList<ResponseType>());
		when(repository.getTotalResponseTypes(reportInput)).thenReturn(new ArrayList<TotalResponseType>());
		when(repository.getTotalResponseTypesNW(reportInput)).thenReturn(new ArrayList<TotalResponseType>());
		when(repository.getResponseAndSourceTypes(reportInput)).thenReturn(new ArrayList<ResponseAndSourceType>());
		when(repository.getResponseAndSourceTypesNW(reportInput)).thenReturn(new ArrayList<ResponseAndSourceType>());
		when(repository.getTop7GapsFL(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsIN(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsNY(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsOH(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsCAStandalone(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsCAIntegrated(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsNW(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getTop7GapsOR(reportInput)).thenReturn(new ArrayList<Top7Gaps>());
		when(repository.getPatientProvidersStandalone(reportInput)).thenReturn(new ArrayList<PatientProvider>());
		when(repository.getPatientProvidersIntegrated(reportInput)).thenReturn(new ArrayList<PatientProvider>());
		when(repository.getPatientProvidersNW(reportInput)).thenReturn(new ArrayList<PatientProvider>());

		assertEquals(MetricsReport.class, service.getMetricsReport(reportInput).getClass());
	}

	@Test
	public void generateExcelFileTest() {
		ReportInput reportInput = new ReportInput();
		MetricsReport metricsReport = new MetricsReport();

		when(fileService.generateExcelFile(metricsReport, reportInput)).thenReturn("path");
		assertEquals("path", service.generateExcelFile(metricsReport, reportInput));

	}
}
