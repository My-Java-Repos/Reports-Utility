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

import com.org.datacore.reports.clinical.model.ClinicalChart;
import com.org.datacore.reports.clinical.model.ClinicalChartReport;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.model.UniqueUser;

@Component
public class ClinicalChartReportExcelFileExporter {

	private static final Logger logger = LoggerFactory.getLogger(ClinicalChartReportExcelFileExporter.class);

	@Value("${upload.path}")
	private String uploadPath;

	public String generateClinicalChartReportExcelFile(ClinicalChartReport clinicalReport, ReportInput reportInput) {

		String path = "";
		try (Workbook workbook = new XSSFWorkbook()) {

			CellStyle headerCellStyle = getCellStyle(workbook);

			Sheet sheet = workbook.createSheet(CLINICAL_REPORT);
			writeFileDetails(sheet, clinicalReport, headerCellStyle);

			// Write the workbook in file system

			DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			String sDate = formatter.format(reportInput.getStartDate());
			String eDate = formatter.format(reportInput.getEndDate());

			path = uploadPath + REPORT_NAME + sDate + "-" + eDate + FILE_EXT;

			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();

			logger.info("Clinical Chart Report creation is done");
			return path;
		} catch (Exception ex) {

			logger.info("Clinical Chart Report creation is failed");
			ex.printStackTrace();
			return path;

		}

	}

	private void writeFileDetails(Sheet sheet, ClinicalChartReport clinicalReport, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);

		int count = 0;
		// Creating header
		Cell cell = row.createCell(count);
		cell.setCellValue("File Name");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue("GMPI");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue("Subscriber ID");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue("Last");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue("First");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(5);
		cell.setCellValue("DOB");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(6);
		cell.setCellValue("DOS");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(7);
		cell.setCellValue("Submitted Date");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(8);
		cell.setCellValue("Entity/Market");
		cell.setCellStyle(headerCellStyle);

		// Creating data rows for each customer
		for (ClinicalChart chart : clinicalReport.getClinicalCharts()) {
			Row dataRow = sheet.createRow(count + 1);
			count++;
			dataRow.createCell(0).setCellValue(chart.getFileName());
			dataRow.createCell(1).setCellValue(chart.getGmpi());
			dataRow.createCell(2).setCellValue(chart.getSubscriberID());
			dataRow.createCell(3).setCellValue(chart.getLastName());
			dataRow.createCell(4).setCellValue(chart.getFirstName());
			if (chart.getDob() != null) {
				dataRow.createCell(5).setCellValue(chart.getDob().toString());
			} else {
				dataRow.createCell(5).setCellValue(chart.getDob());
			}
			if (chart.getDos() != null) {
				dataRow.createCell(6).setCellValue(chart.getDos().toString());
			} else {
				dataRow.createCell(6).setCellValue(chart.getDos());
			}
			
		
			dataRow.createCell(7).setCellValue(chart.getSubmittedDate().toString());
			dataRow.createCell(8).setCellValue(chart.getEntity());

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

	}

	public CellStyle getCellStyle(Workbook workbook) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return headerCellStyle;
	}

	private static final String REPORT_NAME = "/DataCORE_Clinical Chart_";
	private static final String FILE_EXT = ".xlsx";
	private static final String DATE_FORMAT = "MMMdd";
	private static final String CLINICAL_REPORT = "DataMock Up Report";
}
