@CURD_Function
Feature: Read data with API

@BCNP-22 @Read_Data
Scenario: As a Green Cart user, need to get data with API 

Given Setup test data in JSON format & connect get method with URL
Then check Status code
And check Response time
And check Content-type json or not
And  Check body data null or not

@BCNP-24 @Create_Data
Scenario: As a Green Cart user, need to create data with API

Given Setup test data in JSON format & connect post method with URL
Then check Status code
And check Response time
And check Content-type json or not
And  Check body data null or not
And  Check attribute origin is there or not there
And Check brocolli value 


