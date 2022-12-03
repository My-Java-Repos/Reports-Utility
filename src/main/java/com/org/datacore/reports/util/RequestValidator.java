package com.org.datacore.reports.util;

import org.springframework.stereotype.Component;

import com.org.datacore.reports.model.ReportInput;

@Component
public class RequestValidator {

	public boolean validateRequest(ReportInput reportInput) {

		if (reportInput.getStartDate() != null && reportInput.getEndDate() != null) {

			int diff = reportInput.getEndDate().compareTo(reportInput.getStartDate());

			if (diff > 0) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}

	}

}
