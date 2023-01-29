package com.curd.functions.test;

import org.json.simple.JSONObject;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;
import com.test.data.handle.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update {
	
	public static Response put() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Brocolli", 150);
		jo.addProperty("Cauliflower", 60);
		jo.addProperty("Cucumber", 48);
		
		JSONObject root = new JSONObject();
		root.put("Green_Cart_Product_Page",  jo);
		
		RequestSpecification rs = RestAssured.given();
		rs.body(root.toString());
		rs.header("Content-Type","application/json");
		
		Response response= rs.put(Constants.PUT_URL);
		
		
		return response;
	}

}
