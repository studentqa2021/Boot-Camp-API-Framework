package com.api.testng.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Read;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_CIRD_Function_Test_Read extends ExtentReportAutomation{
	
	
	API_Test_Validation test_Validation = new API_Test_Validation();
	Response get_response;
	@BeforeTest
	public void setupRead() {
		get_response =Read.get();
	}
	
	@Test
	public void getStatusCode() {
		test_Validation.statusCode(get_response);
		
	}
		
	@Test
	public void getResponseTime() {
		test_Validation.responceTime(get_response);
	}
	
	@Test
	public void checkDataFormat() {
		test_Validation.checkDataFOrmat(get_response);
	}
	
	@Test
	public void checkResponseBodyNull_OR_Not() {
		test_Validation.responseBodyCheck(get_response);

	}

}
