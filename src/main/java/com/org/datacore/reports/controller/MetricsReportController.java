package com.org.datacore.reports.controller;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.datacore.reports.clinical.model.ClinicalChartReport;
import com.org.datacore.reports.model.MetricsReport;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.service.MetricsReportService;
import com.org.datacore.reports.util.Constants;
import com.org.datacore.reports.util.RequestValidator;

@Controller
public class MetricsReportController {

	private static final Logger logger = LoggerFactory.getLogger(MetricsReportController.class);

	@Autowired
	MetricsReportService service;

	@Autowired
	RequestValidator validator;

	@RequestMapping(value = "/")
	public String homePage(Model model) {
		model.addAttribute("reportInput", new ReportInput());
		model.addAttribute("error", "");
		return "index";
	}

	@RequestMapping(value = "/getReport", method = RequestMethod.POST)
	public String getMetricsReport(Model model, @ModelAttribute("reportInput") ReportInput reportInput) {

		try {

			boolean flag = validator.validateRequest(reportInput);

			if (flag) {
				String report = reportInput.getName();

				if (report != null && report.equalsIgnoreCase(Constants.METRICS_REPORT)) {

					logger.info("metrics report intiated ");
					MetricsReport metricsReport = service.getMetricsReport(reportInput);
					logger.info("Data collected from DB ");

					String path = service.generateExcelFile(metricsReport, reportInput);

					if (path != null && !Strings.isEmpty(path)) {
						logger.info("Data added in Excel file  ");
						model.addAttribute("message", "Report genarated in this location : " + path);
					} else {
						logger.info("Data stored in Excel file is Failed");
						model.addAttribute("message", "report genaration is failed");
					}

				} else if (report != null && report.equalsIgnoreCase(Constants.CLINICAL_REPORT)) {

					logger.info("Clinical Chart report intiated ");
					ClinicalChartReport clinicalReport = service.getclinicalChartReport(reportInput);
					logger.info("Clinical Chart Data collected from DB ");

					String path = service.generateClinicalChartReportExcelFile(clinicalReport, reportInput);

					if (path != null && !Strings.isEmpty(path)) {
						logger.info("Clinical Chart Data added in Excel file  ");
						model.addAttribute("message", "Clinical Chart Report genarated in this location : " + path);
					} else {
						logger.info("Clinical Chart Data stored in Excel file is Failed");
						model.addAttribute("message", "Clinical Chart Report genaration is failed");
					}

				} else {
					model.addAttribute("error", "Name feild is empty / Please select the report ");
				}

				model.addAttribute("reportInput", reportInput);
				return "index";

			} else {
				model.addAttribute("reportInput", reportInput);
				model.addAttribute("error", "Date feild is empty / Please enter dates in order ");
				return "index";
			}

		} catch (Exception ex) {

			model.addAttribute("error", "Something went wrong");
			ex.printStackTrace();
			return "error";
		}

	}

}
