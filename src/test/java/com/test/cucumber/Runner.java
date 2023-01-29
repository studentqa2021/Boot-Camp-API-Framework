package com.test.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"json:target/cucumber.json"},
		features = {"src/main/resources/API_CURD_Function.feature"},
		glue = {"com.test.cucumber"},
		monochrome = true
		//@tag= {"Create_Data"}
		//dryRun = false,
		//strict = true
		
		)
public class Runner extends AbstractTestNGCucumberTests {

}
