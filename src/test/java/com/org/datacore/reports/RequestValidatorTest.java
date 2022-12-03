package com.org.datacore.reports;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.util.RequestValidator;

@ExtendWith(MockitoExtension.class)
public class RequestValidatorTest {

	@InjectMocks
	RequestValidator validator;
	
	@Test
	public void validateRequestTest() {
		
		ReportInput reportInput = new ReportInput();
		assertFalse(validator.validateRequest(reportInput));
	}
	
	@Test
	public void validateRequestSameDatesTest() {
		
		ReportInput reportInput = new ReportInput();
		reportInput.setEndDate(new Date());
		reportInput.setStartDate(new Date());
		assertFalse(validator.validateRequest(reportInput));
	}
	

	@Test
	public void validateRequestForDiffDatesTest() {
		final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
		ReportInput reportInput = new ReportInput();
		reportInput.setEndDate(new Date(new Date().getTime() + MILLIS_IN_A_DAY));
		reportInput.setStartDate(new Date());
		assertTrue(validator.validateRequest(reportInput));
	}
}
