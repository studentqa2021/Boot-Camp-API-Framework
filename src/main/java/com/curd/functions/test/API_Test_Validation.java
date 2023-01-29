package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Test_Validation {
	SoftAssert sf = new SoftAssert();
	public void statusCode(Response response) {
		System.out.println("Status code found =" + response.statusCode());
		sf.assertEquals(response.statusCode(), 200);
		sf.assertAll();
		
	}
	
	public void responceTime(Response response) {
		System.out.println("Response time found =" + response.time());// <3000
		sf.assertTrue(response.time() < 3000);
		sf.assertAll();
		
	}
	public void checkDataFOrmat(Response response) {
		System.out.println("Data format check =" + response.contentType());// JSON
		sf.assertTrue(response.contentType().contains("json"));
		sf.assertAll();
		
	}
	public void responseBodyCheck(Response response) {
		System.out.println("Data should not be null =" + response.body().asString());// null or not null
		sf.assertTrue(!response.body().asString().equals(null));
		sf.assertAll();
		
	}
	
	public void attributeCheck(Response response,String attributeName) {
		System.out.println("Data should contains origin =" + response.body().asString().contains("origin"));// null or not null
		sf.assertTrue(response.body().asString().contains(attributeName)," >>But actual dat found = "+response.body().toString());
		sf.assertAll();
		
	}
	
	
	public void ValueCheck(Response response,int value) {
		JsonPath jp =response.jsonPath();
		String actualBrokoliValue =jp.get("json.Green_Cart_Product_Page.Brocolli").toString();
		System.out.println(" value check = "+actualBrokoliValue);
		sf.assertEquals(actualBrokoliValue, String.valueOf(value));
		sf.assertAll();
		
	}
//	public static void testCases(Response response) {
//		SoftAssert sf = new SoftAssert();
//		// Test cases
//				// 1st=status code=200
//				System.out.println("Status code found =" + response.statusCode());
//				sf.assertEquals(response.statusCode(), 200);
//				// 2nd= response time
//				System.out.println("Response time found =" + response.time());// <3000
//				sf.assertTrue(response.time() < 3000);
//				// 3rd= data format check >> contenttype
//				System.out.println("Data format check =" + response.contentType());// JSON
//				sf.assertTrue(response.contentType().contains("json"));
//				// 4th= body data null or not
//				System.out.println("Data should not be null =" + response.body().asString());// null or not null
//				sf.assertTrue(!response.body().asString().equals(null));
//	// 5th= body data contains any attribute
//			System.out.println("Data should contains origin =" + response.body().asString().contains("origin"));// null or not null
//			sf.assertTrue(response.body().asString().contains("origin")," >>But actual dat found = "+response.body().toString());
//			//6th = body data value match
//			JsonPath jp =response.jsonPath();
//			String actualBrokoliValue =jp.get("json.Brocolli").toString();
//			System.out.println(" value check = "+actualBrokoliValue);
//			sf.assertEquals(actualBrokoliValue, String.valueOf(value));
//			
//			sf.assertAll();

//	}

}
