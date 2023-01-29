package com.api.testng.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.curd.functions.test.API_Coomon_Test_Cases;
import com.curd.functions.test.ReadData;
import com.report.ExtentReportAutomation;

import io.restassured.response.Response;

public class API_Read_Data extends ExtentReportAutomation {
	API_Coomon_Test_Cases testValidation = new API_Coomon_Test_Cases();
	Response response;
	
	@BeforeTest
	public void setup() {
		ReadData obj = new ReadData();
		 response =obj.getSetup();	
	}
	
	@Test(priority =0)
	public void chechStatusCode() {
		testValidation.checkStatusCode(response);
	}
	@Test(priority =1)
	public void chechResponceTime() {
		testValidation.checkResponseTime(response);
	}
	@Test(priority =2)
	public void chechDataFormat() {
		testValidation.checkDataFormat(response);
	}
	@Test(priority =3)
	public void chechDataNull_OR_NOT() {
		testValidation.checkDataNotNull(response);
	}		
			
			
			
			
	
	
}
