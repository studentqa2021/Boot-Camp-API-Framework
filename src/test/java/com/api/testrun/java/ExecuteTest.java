package com.api.testrun.java;

import com.curd.functions.test.API_Coomon_Test_Cases;
import com.curd.functions.test.ReadData;

import io.restassured.response.Response;

public class ExecuteTest {

	public static void main(String[] args) {
		//Setup=get
		ReadData obj = new ReadData();
		Response response =obj.getSetup();
		//get Test cases
		API_Coomon_Test_Cases testValidation = new API_Coomon_Test_Cases();
		testValidation.checkStatusCode(response);
		testValidation.checkResponseTime(response);
		testValidation.checkDataFormat(response);
		testValidation.checkDataNotNull(response);
	}
	
}
