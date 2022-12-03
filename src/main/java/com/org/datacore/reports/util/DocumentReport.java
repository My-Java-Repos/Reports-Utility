package com.org.datacore.reports.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.org.datacore.reports.clinical.model.FileInfo;
import com.org.datacore.reports.clinical.model.PatientInfo;


@Component
public class DocumentReport {

	private static final Logger logger = LoggerFactory.getLogger(DocumentReport.class);

	@Value("${upload.path}")
	private String uploadPath;

	private static final String FILE_EXT = ".xlsx";

	public void prepareDocumnetReport(Map<FileInfo, List<PatientInfo>> updateTimeNotMatched, String string) {

		String path = "";
		try (Workbook workbook = new XSSFWorkbook()) {

			CellStyle headerCellStyle = getCellStyle(workbook);

			Sheet sheet = workbook.createSheet("DocumnetsInfo");
			wriiteDocumnetReport(sheet, updateTimeNotMatched, headerCellStyle);

			path = uploadPath + "/" + string + FILE_EXT;

			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
		} catch (Exception ex) {

			logger.info("report creation is failed");
			ex.printStackTrace();

		}

	}

	public void wriiteDocumnetReport(Sheet sheet, Map<FileInfo, List<PatientInfo>> updateTimeNotMatched,
			CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue("FileName");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue("PersonId");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue("First Name");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue("Last Name");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue("HCC Code");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(5);
		cell.setCellValue("ICC Code");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(6);
		cell.setCellValue("DOB");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(7);
		cell.setCellValue("DOS");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(8);
		cell.setCellValue("Status");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(9);
		cell.setCellValue("RefDate");
		cell.setCellStyle(headerCellStyle);
		
		cell = row.createCell(10);
		cell.setCellValue("attestation UpdateTime");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(11);
		cell.setCellValue("File UpdateTime");
		cell.setCellStyle(headerCellStyle);
		
		cell = row.createCell(12);
		cell.setCellValue("Entity");
		cell.setCellStyle(headerCellStyle);
		

		int count = 0;
		// Creating data rows for each customer
		for (FileInfo file : updateTimeNotMatched.keySet()) {

			List<PatientInfo> list = updateTimeNotMatched.get(file);
			Set<PatientInfo> li = new HashSet<PatientInfo>(list);
			
			for (int i = 0; i < li.size(); i++) {
			
				Row dataRow = sheet.createRow(count+1);
				count++;
				dataRow.createCell(0).setCellValue(file.getFileName());
				dataRow.createCell(1).setCellValue(list.get(i).getPersonID());
				dataRow.createCell(2).setCellValue(list.get(i).getFirstName());
				dataRow.createCell(3).setCellValue(list.get(i).getLastNAme());
				dataRow.createCell(4).setCellValue(list.get(i).getHccCode());
				dataRow.createCell(5).setCellValue(list.get(i).getIccCode());
				dataRow.createCell(6).setCellValue(list.get(i).getDob().toString());
				if(list.get(i).getDos() !=null)
				dataRow.createCell(7).setCellValue(list.get(i).getDos().toString());
				dataRow.createCell(8).setCellValue(list.get(i).getStatus());
				dataRow.createCell(9).setCellValue(list.get(i).getRefDate().toString());
				dataRow.createCell(10).setCellValue(list.get(i).getUpdateTime().toString());
				dataRow.createCell(11).setCellValue(file.getUpdateDtm().toString());
				dataRow.createCell(12).setCellValue(list.get(i).getEntity());
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
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		sheet.autoSizeColumn(10);
		sheet.autoSizeColumn(11);
		sheet.autoSizeColumn(12);
	}

	public CellStyle getCellStyle(Workbook workbook) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return headerCellStyle;
	}

	public void collectDocuments(List<FileInfo> noGaps, String string) {
		
		String path = "";
		try (Workbook workbook = new XSSFWorkbook()) {

			CellStyle headerCellStyle = getCellStyle(workbook);

			Sheet sheet = workbook.createSheet("DocumnetsInfo");
			collectDocumentsInFile(sheet, noGaps, headerCellStyle);

			path = uploadPath + "/" + string + FILE_EXT;

			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
		} catch (Exception ex) {

			logger.info("report creation is failed");
			ex.printStackTrace();

		}
	}

	public void collectDocumentsInFile(Sheet sheet, List<FileInfo> noGaps, CellStyle headerCellStyle) {

		Row row = sheet.createRow(0);
		int count = 0;
		// Creating header
		Cell cell = row.createCell(0);
		cell.setCellValue("id");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue("File Name");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue("Person ID");
		cell.setCellStyle(headerCellStyle);
		
		cell = row.createCell(3);
		cell.setCellValue("Sate");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue("UpdateTime");
		cell.setCellStyle(headerCellStyle);
		
		// Creating data rows for each customer
		for (FileInfo file : noGaps) {
			Row dataRow = sheet.createRow(count + 1);
			count++;
			dataRow.createCell(0).setCellValue(file.getId());
			dataRow.createCell(1).setCellValue(file.getFileName());
			dataRow.createCell(2).setCellValue(file.getPersonID());
			dataRow.createCell(3).setCellValue(file.getState());
			dataRow.createCell(4).setCellValue(file.getUpdateDtm().toString());

		}
		// Making size of column auto resize to fit with data
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		
	}

}
