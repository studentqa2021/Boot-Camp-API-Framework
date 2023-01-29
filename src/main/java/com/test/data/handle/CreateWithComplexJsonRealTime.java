package com.test.data.handle;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateWithComplexJsonRealTime {

	public static void readJson() throws JsonParseException, JsonMappingException, IOException {
		String path = "./src/test/resources/TestJson.json";
		File file = new File(path).getAbsoluteFile();
		List<String> jsonData = new LinkedList<>();
		DocumentContext documentContext = JsonPath.parse(file);
		jsonData.add(documentContext.read("$.SmartTech").toString());
		//System.out.println("" + documentContext.read("$"));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JSONObject root = new JSONObject();
		root.put("Smart Tech",  documentContext.read("$.SmartTech"));
		String jsonString = gson.toJson(root);
		//System.out.println(jsonString);
		RequestSpecification rs = RestAssured.given();
		rs.body(root.toString());
		// 3rd >> test data format in header
		rs.header("Content-Type", "application/json");
		// use post() and send new data via post URL
		Response response = rs.post("https://httpbin.org/post");
		System.out.println(response.body().prettyPrint());
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		readJson();
	}
}
