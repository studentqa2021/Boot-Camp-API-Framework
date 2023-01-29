package com.api.testng.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Update;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_CIRD_Function_Test_Update extends ExtentReportAutomation{
	
	
	API_Test_Validation test_Validation= new API_Test_Validation();
	Response put_response;
	@BeforeTest
	public void setupUpdate() {
		put_response =Update.put();

	}
	
	@Test
	public void getStatusCode() {
		test_Validation.statusCode(put_response);
		
	}
		
	@Test
	public void getResponseTime() {
		test_Validation.responceTime(put_response);
	}
	
	@Test
	public void checkDataFormat() {
		test_Validation.checkDataFOrmat(put_response);
	}
	
	@Test
	public void checkResponseBodyNull_OR_Not() {
		test_Validation.responseBodyCheck(put_response);

	}
	@Test
	public void checkAttributePresentOR_Not() {
		test_Validation.attributeCheck(put_response,"origin");

	}
	@Test
	public void checkValue() {
		test_Validation.ValueCheck(put_response, 150);
	}
}
