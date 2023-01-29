package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Coomon_Test_Cases {
	
	SoftAssert sa = new SoftAssert();
	
	public void checkStatusCode(Response response){
		sa.assertEquals(response.statusCode(), 200);
	}

	public void checkResponseTime(Response respone){
		boolean status= respone.time()<3000;
		sa.assertTrue(status);
	}
	public void checkDataFormat(Response respone){
		boolean status=respone.contentType().toString().contains("json");
		sa.assertTrue(status);
		
	}
	public void checkDataNotNull(Response response){
	boolean status=	!(response.body().asString().equals(null));
	sa.assertTrue(status);
	}
	
	public void checkOriginIsPresent(Response response){
		boolean status=	(response.body().asString().contains("origin"));
		sa.assertTrue(status);
		}
	
	public void checkAttributeValue(Response response,int value){
		JsonPath jp =response.jsonPath();
		String actualBrokoliValue =jp.get("json.Green_Cart_Product_Page.Brocolli").toString();
		
		sa.assertEquals(actualBrokoliValue, String.valueOf(value));
		sa.assertAll();
	}
	

}
