package com.curd.functions.test;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.test.data.handle.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {

	public static Response postsetup() {
		// 1st>> write test data into JSON
		JsonObject jo = new JsonObject();	
		jo.addProperty("Brocolli", 120);
		jo.addProperty("Cauliflower", 60);
		jo.addProperty("Cucumber", 48);
		
		JSONObject root = new JSONObject();
		root.put("Green_Cart_Product_Page",  jo);
		// 2nd>add json data inside body
		RequestSpecification rs = RestAssured.given();
		rs.body(root.toString());
		// 3rd >> test data format in header
		rs.header("Content-Type", "application/json");
		// use post() and send new data via post URL
		Response response = rs.post(Constants.POST_URL);
		
		return response;
	}

}
