package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import com.test.data.handle.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Read {
	
	public static Response get() {
		
		Response response = RestAssured.get(Constants.GET_URL);
		System.out.println(response.prettyPrint());
		
		
		return response;
	}

}
