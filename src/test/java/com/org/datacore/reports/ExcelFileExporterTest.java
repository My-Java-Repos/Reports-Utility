package com.org.datacore.reports;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

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
import com.org.datacore.reports.util.ExcelFileExporter;

@ExtendWith(MockitoExtension.class)
public class ExcelFileExporterTest {

	@InjectMocks
	ExcelFileExporter fileExp;

	@Test
	public void generateExcelFileTest() {

		ReportInput reportInput = new ReportInput();
		reportInput.setStartDate(new Date());
		reportInput.setEndDate(new Date());
		MetricsReport metricsReport = new MetricsReport();
		ReflectionTestUtils.setField(fileExp, "uploadPath", System.getProperty("java.class.path"));

		List<UniqueUser> uniqueUsers = new ArrayList<UniqueUser>();
		List<UniqueProvider> uniqueProviders = new ArrayList<UniqueProvider>();
		List<UniqueMember> uniqueMembers = new ArrayList<UniqueMember>();
		List<SourceType> sourceTypes = new ArrayList<SourceType>();
		List<ResponseType> responseTypes = new ArrayList<ResponseType>();
		List<TotalResponseType> totalResponseTypes = new ArrayList<TotalResponseType>();
		List<ResponseAndSourceType> responseAndSourceTypes = new ArrayList<ResponseAndSourceType>();
		List<Top7Gaps> top7Gaps = new ArrayList<Top7Gaps>();
		List<PatientProvider> patientProviders = new ArrayList<PatientProvider>();

		uniqueUsers.add(new UniqueUser("avc", "axd", 8));
		uniqueProviders.add(new UniqueProvider("avc", "axd", 8));
		uniqueMembers.add(new UniqueMember("avc", "axd", 8));
		sourceTypes.add(new SourceType("avc", "axd", "", 8));
		responseTypes.add(new ResponseType("avc", "axd", "", 8));
		totalResponseTypes.add(new TotalResponseType("avc", "axd", 8));
		responseAndSourceTypes.add(new ResponseAndSourceType("avc", "axd", "", "", 8));
		top7Gaps.add(new Top7Gaps("avc", "axd", 7, 8, 9, 6, 6, 8));
		patientProviders
				.add(new PatientProvider("avc", "axd", "", "", "", "", new Date(), new Date(), "", "", "", "", "ui"));

		metricsReport.setUniqueUsers(uniqueUsers);
		metricsReport.setUniqueProviders(uniqueProviders);
		metricsReport.setUniqueMembers(uniqueMembers);
		metricsReport.setSourceTypes(sourceTypes);
		metricsReport.setResponseTypes(responseTypes);
		metricsReport.setResponseAndSourceTypes(responseAndSourceTypes);
		metricsReport.setTotalResponseTypes(totalResponseTypes);
		metricsReport.setTop7Gaps(top7Gaps);
		metricsReport.setPatientProviders(patientProviders);

		assertNotEquals("", fileExp.generateExcelFile(metricsReport, reportInput));
	}
}
