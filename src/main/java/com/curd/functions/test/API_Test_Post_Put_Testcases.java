package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Test_Post_Put_Testcases {
	
	public static void testCases(Response response,int value) {

		SoftAssert sf = new SoftAssert();
		
		// 5th= body data contains any attribute
		System.out.println("Data should contains origin =" + response.body().asString().contains("origin"));// null or not null
		sf.assertTrue(response.body().asString().contains("origin")," >>But actual dat found = "+response.body().toString());
		//6th = body data value match
		JsonPath jp =response.jsonPath();
		String actualBrokoliValue =jp.get("json.Brocolli").toString();
		System.out.println(" value check = "+actualBrokoliValue);
		sf.assertEquals(actualBrokoliValue, String.valueOf(value));
		
		sf.assertAll();
	}

}
