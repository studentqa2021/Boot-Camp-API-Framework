package com.api.testng.framework;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Coomon_Test_Cases;
import com.curd.functions.test.CreateWIthPost;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_Create_Data extends ExtentReportAutomation{
	API_Coomon_Test_Cases testValidation = new API_Coomon_Test_Cases();
	Response response;
	
	@BeforeTest
	public void setup() {
	CreateWIthPost obj = new CreateWIthPost();
	JSONObject finalJSON = obj.getTestDatainJSON();
	 response =obj.setup(finalJSON);
	}

	// Testcases
	@Test(priority =0)
	public void statusCode() {
		testValidation.checkStatusCode(response);
	}
	
	@Test(priority =1)
	public void responseTime() {
		testValidation.checkResponseTime(response);
	}
	@Test(priority =2)
	public void dataFormatCheck() {
		testValidation.checkDataFormat(response);
	}
	@Test(priority =3)
	public void dataNull_OR_NOt() {
		testValidation.checkDataNotNull(response);
	}
	
	
	//Post testcases
	@Test(priority =4)
	public void checkOriginIsPresent() {
		testValidation.checkOriginIsPresent(response);
	}
	@Test(priority =5)
	public void checkAttributeValue() {
		testValidation.checkAttributeValue(response,120);
	}
	
	
	
}
