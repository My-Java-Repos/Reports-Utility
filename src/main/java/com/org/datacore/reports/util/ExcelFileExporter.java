package com.org.datacore.reports.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

import java.util.List;

@Component
public class ExcelFileExporter {

	private static final Logger logger = LoggerFactory.getLogger(ExcelFileExporter.class);

	@Value("${upload.path}")
	private String uploadPath;

	private static final String DATE_FORMAT = "MMMdd";
	private static final String UNIQUE_USERS = "Unique Users";
	private static final String UNIQUE_PROVIDERS_COUNT = "Unique Provider Count";
	private static final String UNIQUE_MEMBER_COUNT = "Unique Member Record Count";
	private static final String SOURCE_TYPE_COUNTS = "Source Type Counts";
	private static final String RESPONSE_TYPE_COUNTS = "Response Type Counts";
	private static final String TOTAL_RESPONSE_TYPE_COUNTS = "Total Response Type Counts";
	private static final String RESPONSE_SOURCE_TYPE_COUNTS = "Response & Source Type Counts";
	private static final String TOP7GAPS = "Top 7 Gaps";
	private static final String PATIENT_PROVIDER_REPORT = "Patient-Provider Report";
	private static final String REPORT_NAME = "/DataCORE_Metrics&Report_";
	private static final String FILE_EXT = ".xlsx";
	private static final String NAME = "Name";
	private static final String TYPE = "Type";
	private static final String COUNT = "Count";
	private static final String TOTAL_COUNT = "TotalCount";
	private static final String SOURCE_TYPE = "SourceType";
	private static final String RESPONSE_TYPE = "ResponseType";
	private static final String HCCCODE = "HCCCode";

	private static final String RECAPTURECOUNT = "RECAPTURE_COUNT";
	private static final String SUSPECTCOUNT = "SUSPECT_COUNT";
	private static final String INSUFFICIENTCOUNT = "INSUFFICIENT_COUNT";
	private static final String CMS_SUSPECTCOUNT = "CMS_SUSPECT_COUNT";

	public String generateExcelFile(MetricsReport metricsReport, ReportInput reportInput) {

		String path = "";
		try (Workbook workbook = new XSSFWorkbook()) {

			CellStyle headerCellStyle = getCellStyle(workbook);

			Sheet sheet = workbook.createSheet(UNIQUE_USERS);
			writeUniqueUsers(sheet, metricsReport.getUniqueUsers(), headerCellStyle);

			sheet = workbook.createSheet(UNIQUE_PROVIDERS_COUNT);
			writeUniqueProviders(sheet, metricsReport.getUniqueProviders(), headerCellStyle);

			sheet = workbook.createSheet(UNIQUE_MEMBER_COUNT);
			writeUniqueMembers(sheet, metricsReport.getUniqueMembers(), headerCellStyle);

			sheet = workbook.createSheet(SOURCE_TYPE_COUNTS);
			writeSourceTypes(sheet, metricsReport.getSourceTypes(), headerCellStyle);

			sheet = workbook.createSheet(RESPONSE_TYPE_COUNTS);
			writeResponseTypes(sheet, metricsReport.getResponseTypes(), headerCellStyle);

			sheet = workbook.createSheet(TOTAL_RESPONSE_TYPE_COUNTS);
			writeTotalResponseTypes(sheet, metricsReport.getTotalResponseTypes(), headerCellStyle);

			sheet = workbook.createSheet(RESPONSE_SOURCE_TYPE_COUNTS);
			writeResponseAndSourceTypes(sheet, metricsReport.getResponseAndSourceTypes(), headerCellStyle);

			sheet = workbook.createSheet(TOP7GAPS);
			writeTop7Gaps(sheet, metricsReport.getTop7Gaps(), headerCellStyle);

			sheet = workbook.createSheet(PATIENT_PROVIDER_REPORT);
			writePatientProviders(sheet, metricsReport.getPatientProviders(), headerCellStyle);

			// Write the workbook in file system

			DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			String sDate = formatter.format(reportInput.getStartDate());
			String eDate = formatter.format(reportInput.getEndDate());

			path = uploadPath + REPORT_NAME + sDate + "-" + eDate + FILE_EXT;

			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();

			logger.info("DataCORE_Metrics&Report creation is done");
			return path;

		} catch (Exception ex) {

			logger.info("DataCORE_Metrics&Report creation is failed");
			ex.printStackTrace();
			return path;

		}
	}

	public CellStyle getCellStyle(Workbook workbook) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return headerCellStyle;
	}

	public void writeUniqueUsers(Sheet sheet, List<UniqueUser> uniqueUsers, CellStyle headerCellStyle) {
		Row row = sheet.createRow(0);

		int count = 0;
		// Creating header
		Cell cell = row.createCell(count);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (UniqueUser uniqueUser : uniqueUsers) {
			Row dataRow = sheet.createRow(count + 1);
			count++;
			dataRow.createCell(0).setCellValue(uniqueUser.getName());
			dataRow.createCell(1).setCellValue(uniqueUser.getType());
			dataRow.createCell(2).setCellValue(uniqueUser.getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
	}

	public void writeUniqueProviders(Sheet sheet, List<UniqueProvider> uniqueProviders, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < uniqueProviders.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(uniqueProviders.get(i).getName());
			dataRow.createCell(1).setCellValue(uniqueProviders.get(i).getType());
			dataRow.createCell(2).setCellValue(uniqueProviders.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
	}

	public void writeUniqueMembers(Sheet sheet, List<UniqueMember> uniqueMembers, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < uniqueMembers.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(uniqueMembers.get(i).getName());
			dataRow.createCell(1).setCellValue(uniqueMembers.get(i).getType());
			dataRow.createCell(2).setCellValue(uniqueMembers.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);

	}

	public void writeSourceTypes(Sheet sheet, List<SourceType> sourceTypes, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(SOURCE_TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		for (int i = 0; i < sourceTypes.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(sourceTypes.get(i).getName());
			dataRow.createCell(1).setCellValue(sourceTypes.get(i).getType());
			dataRow.createCell(2).setCellValue(sourceTypes.get(i).getSourceType());
			dataRow.createCell(3).setCellValue(sourceTypes.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);

	}

	public void writeResponseTypes(Sheet sheet, List<ResponseType> responseTypes, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(RESPONSE_TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < responseTypes.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(responseTypes.get(i).getName());
			dataRow.createCell(1).setCellValue(responseTypes.get(i).getType());
			dataRow.createCell(2).setCellValue(responseTypes.get(i).getResponseType());
			dataRow.createCell(3).setCellValue(responseTypes.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
	}

	public void writeTotalResponseTypes(Sheet sheet, List<TotalResponseType> totalResponseTypes,
			CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < totalResponseTypes.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(totalResponseTypes.get(i).getName());
			dataRow.createCell(1).setCellValue(totalResponseTypes.get(i).getType());
			dataRow.createCell(2).setCellValue(totalResponseTypes.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
	}

	public void writeResponseAndSourceTypes(Sheet sheet, List<ResponseAndSourceType> responseAndSourceTypes,
			CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(RESPONSE_TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue(SOURCE_TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue(COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < responseAndSourceTypes.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(responseAndSourceTypes.get(i).getName());
			dataRow.createCell(1).setCellValue(responseAndSourceTypes.get(i).getType());
			dataRow.createCell(2).setCellValue(responseAndSourceTypes.get(i).getResponseType());
			dataRow.createCell(3).setCellValue(responseAndSourceTypes.get(i).getSourceType());
			dataRow.createCell(4).setCellValue(responseAndSourceTypes.get(i).getCount());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);

	}

	public void writeTop7Gaps(Sheet sheet, List<Top7Gaps> top7Gaps, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue(HCCCODE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue(CMS_SUSPECTCOUNT);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue(INSUFFICIENTCOUNT);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(5);
		cell.setCellValue(SUSPECTCOUNT);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(6);
		cell.setCellValue(RECAPTURECOUNT);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(7);
		cell.setCellValue(TOTAL_COUNT);
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer

		int count = 1;
		int rowN = 1;
		for (Top7Gaps t7 : top7Gaps) {
			Row dataRow = sheet.createRow(rowN);
			dataRow.createCell(0).setCellValue(t7.getName());
			dataRow.createCell(1).setCellValue(t7.getType());
			dataRow.createCell(2).setCellValue(t7.getHCCCode());
			dataRow.createCell(3).setCellValue(t7.getCms_suspectCount());
			dataRow.createCell(4).setCellValue(t7.getInsufficientCount());
			dataRow.createCell(5).setCellValue(t7.getSuspectCount());
			dataRow.createCell(6).setCellValue(t7.getReCaptureCount());
			dataRow.createCell(7).setCellValue(t7.getCount());
			rowN++;
			count++;
			if (count == 8) {
				count = 1;
				dataRow = sheet.createRow(rowN);
				dataRow.createCell(0).setCellValue("");
				dataRow.createCell(1).setCellValue("");
				dataRow.createCell(2).setCellValue("");
				dataRow.createCell(3).setCellValue("");
				dataRow.createCell(4).setCellValue("");
				dataRow.createCell(5).setCellValue("");
				dataRow.createCell(6).setCellValue("");
				dataRow.createCell(7).setCellValue("");
				rowN++;
			}
		}

		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
	}

	public void writePatientProviders(Sheet sheet, List<PatientProvider> patientProviders, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue("Npi");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue("Updated_User_FN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue("Updated_User_LN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue("Updated_User_RoleName");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue(TYPE);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(5);
		cell.setCellValue(NAME);
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(6);
		cell.setCellValue("Date(a.UpdateDttm)");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(7);
		cell.setCellValue("Date(a.CreateDttm)");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(8);
		cell.setCellValue("Create_User_FN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(9);
		cell.setCellValue("Create_User_LN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(10);
		cell.setCellValue("Patient_FN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(11);
		cell.setCellValue("Patient_LN");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(12);
		cell.setCellValue("Member_Id");
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (int i = 0; i < patientProviders.size(); i++) {

			Row dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(patientProviders.get(i).getNpi());
			dataRow.createCell(1).setCellValue(patientProviders.get(i).getUpdatedUserFN());
			dataRow.createCell(2).setCellValue(patientProviders.get(i).getUpdatedUserLN());
			dataRow.createCell(3).setCellValue(patientProviders.get(i).getUpdatedUserRole());
			dataRow.createCell(4).setCellValue(patientProviders.get(i).getType());
			dataRow.createCell(5).setCellValue(patientProviders.get(i).getName());
			dataRow.createCell(6).setCellValue(patientProviders.get(i).getUpdateDtm());
			dataRow.createCell(7).setCellValue(patientProviders.get(i).getCreateDtm());
			dataRow.createCell(8).setCellValue(patientProviders.get(i).getCreatedUserFN());
			dataRow.createCell(9).setCellValue(patientProviders.get(i).getCreatedUserLN());
			dataRow.createCell(10).setCellValue(patientProviders.get(i).getPatientFN());
			dataRow.createCell(11).setCellValue(patientProviders.get(i).getPatientLN());
			dataRow.createCell(12).setCellValue(patientProviders.get(i).getMemberId());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		sheet.autoSizeColumn(10);
		sheet.autoSizeColumn(11);
		sheet.autoSizeColumn(12);
	}

}
