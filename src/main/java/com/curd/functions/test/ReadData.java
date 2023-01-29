package com.curd.functions.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadData {
	
	public Response getSetup(){
		Response respone =RestAssured.get("https://httpbin.org/get");
		respone.prettyPrint();
		respone.statusCode();
		
		
		return respone;
	}

}
