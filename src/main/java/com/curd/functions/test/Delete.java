package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import com.test.data.handle.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {
	
	public static Response delete() {
		
	Response response=RestAssured.delete(Constants.DELETE_URL);
	System.out.println(response.prettyPrint());
	
	return response;
	}

}
