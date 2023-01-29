package com.api.testrun.java;

import com.curd.functions.test.API_Test_Validation;
import com.curd.functions.test.Create;
import com.curd.functions.test.Delete;
import com.curd.functions.test.Read;
import com.curd.functions.test.Update;

import io.restassured.response.Response;

public class APITestRun {

	
	public static void main(String[] args) {
		
		//CURD
		//post
		Response post_response =Create.postsetup();
		API_Test_Validation test = new API_Test_Validation();
		test.statusCode(post_response);
		test.responceTime(post_response);
		test.checkDataFOrmat(post_response);
		test.responseBodyCheck(post_response);
		test.attributeCheck(post_response,"origin");
		test.ValueCheck(post_response, 120);
			
		//get
		Response get_response =Read.get();
		test.statusCode(get_response);
		test.responceTime(get_response);
		test.checkDataFOrmat(get_response);
		test.responseBodyCheck(get_response);
		
		//put
		Response put_response =Update.put();
		test.statusCode(put_response);
		test.responceTime(put_response);
		test.checkDataFOrmat(put_response);
		test.responseBodyCheck(put_response);
		test.attributeCheck(put_response,"origin");
		test.ValueCheck(put_response, 150);
		
		//delete
		Response delete_response =Delete.delete();
		test.statusCode(delete_response);
		test.responceTime(delete_response);
		test.checkDataFOrmat(delete_response);
		test.responseBodyCheck(delete_response);	
	}
}
