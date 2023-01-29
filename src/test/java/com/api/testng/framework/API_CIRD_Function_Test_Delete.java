package com.api.testng.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Delete;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_CIRD_Function_Test_Delete extends ExtentReportAutomation {
	
	
	API_Test_Validation test_Validation= new API_Test_Validation();
	Response delete_response;
	@BeforeTest
	public void setupDelete() {
		delete_response =Delete.delete();
	}
	
	@Test
	public void getStatusCode() {
		test_Validation.statusCode(delete_response);
		
	}
		
	@Test
	public void getResponseTime() {
		test_Validation.responceTime(delete_response);
	}
	
	@Test
	public void checkDataFormat() {
		test_Validation.checkDataFOrmat(delete_response);
	}
	
	@Test
	public void checkResponseBodyNull_OR_Not() {
		test_Validation.responseBodyCheck(delete_response);

	}

}
