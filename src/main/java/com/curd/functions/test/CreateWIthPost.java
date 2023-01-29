package com.curd.functions.test;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateWIthPost {

	public JSONObject getTestDatainJSON() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Brocolli", 120);
		jo.addProperty("Cauliflower", 60);
		jo.addProperty("Cucumber", 48);

		JSONObject finalJSON = new JSONObject();
		finalJSON.put("Green_Cart_Product_Page", jo);

		return finalJSON;
	}

	public Response setup(JSONObject finalJSON) {

		RequestSpecification rs = RestAssured.given();
		rs.body(finalJSON.toString());
		rs.header("Content-Type", "application/json");
		Response response = rs.post("https://httpbin.org/post");

		return response;
	}

}
