package com.api.testng.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Create;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_CIRD_Function_Test_Create extends ExtentReportAutomation {
	
	
	API_Test_Validation test_Validation = new API_Test_Validation();
	Response post_response;
	
	@BeforeTest
	public void setupCreate() {
		post_response =Create.postsetup();
		
	}
	
	@Test
	public void getStatusCode() {
		test_Validation.statusCode(post_response);
		
	}
		
	@Test
	public void getResponseTime() {
		test_Validation.responceTime(post_response);
	}
	
	@Test
	public void checkDataFormat() {
		test_Validation.checkDataFOrmat(post_response);
	}
	
	@Test
	public void checkResponseBodyNull_OR_Not() {
		test_Validation.responseBodyCheck(post_response);

	}
	@Test
	public void checkAttributePresentOR_Not() {
		test_Validation.attributeCheck(post_response,"origin");

	}
	@Test
	public void checkValuet() {
		test_Validation.ValueCheck(post_response, 120);
	}
}
