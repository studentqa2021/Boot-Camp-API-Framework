package com.api.testrun.java;

import org.json.simple.JSONObject;

import com.curd.functions.test.API_Coomon_Test_Cases;
import com.curd.functions.test.CreateWIthPost;

import io.restassured.response.Response;

public class ExectePost {
	public static void main(String[] args) {

		CreateWIthPost obj = new CreateWIthPost();
		JSONObject finalJSON = obj.getTestDatainJSON();
		Response response =obj.setup(finalJSON);

		// Testcases
		API_Coomon_Test_Cases testValidation = new API_Coomon_Test_Cases();
		testValidation.checkStatusCode(response);
		testValidation.checkResponseTime(response);
		testValidation.checkDataFormat(response);
		testValidation.checkDataNotNull(response);
		//Post testcases
		testValidation.checkOriginIsPresent(response);
		testValidation.checkAttributeValue(response,120);
	}

}
