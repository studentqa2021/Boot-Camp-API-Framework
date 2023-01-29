package com.test.cucumber;

import org.json.simple.JSONObject;

import com.curd.functions.test.API_Coomon_Test_Cases;
import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Create;
import com.curd.functions.test.CreateWIthPost;
import com.curd.functions.test.ReadData;
import com.report.ExtentReportAutomation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class StepDef {
	API_Coomon_Test_Cases testValidation = new API_Coomon_Test_Cases();
	Response response;

	@Given("Setup test data in JSON format & connect get method with URL")
	public void setup() {
		ReadData obj = new ReadData();
		response = obj.getSetup();
	}
	@Given("Setup test data in JSON format & connect post method with URL")
	public void setup_test_data_in_JSON_format_connect_post_method_with_URL() {
		CreateWIthPost obj = new CreateWIthPost();
		JSONObject finalJSON = obj.getTestDatainJSON();
		 response =obj.setup(finalJSON);
	}
	@Then("check Status code")
	public void checkStatusCode() {
		testValidation.checkStatusCode(response);
	}

	@Then("check Response time")
	public void checkResponseTime() {
		testValidation.checkResponseTime(response);
	}

	@Then("check Content-type json or not")
	public void checkDataFormat() {
		testValidation.checkDataFormat(response);
	}

	@Then("Check body data null or not")
	public void checkBodyDataNull_Or_Not() {
		testValidation.checkDataNotNull(response);
	}

	@Then("Check attribute origin is there or not there")
	public void check_attribute_origin_is_there_or_not_there() {
		testValidation.checkOriginIsPresent(response);
	}

	@Then("Check brocolli value")
	public void check_brocolli_value() {
		testValidation.checkAttributeValue(response, 120);
	}
}
