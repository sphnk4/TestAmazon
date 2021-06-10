package com.amz.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAPI {
@Test
public void GetAllEmployees(){
	
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	RequestSpecification request = RestAssured.given();
	
	Response response = request.get("/employees");
	
	System.out.println("Status : "+response.getStatusCode());
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//ResponseBody body = response.getBody();
	
	//System.out.println("Response Body is: " + body.asString());
}

@Test
public void GetEmployee(){
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	RequestSpecification request = RestAssured.given();
	
	Response response = request.get("/employee/1");
	
	System.out.println("Status : "+response.getStatusCode());
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//ResponseBody body = response.getBody();
	
	//System.out.println("Response Body is: " + body.asString());
}

@Test
public void DeleteEmployee(){
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	RequestSpecification request = RestAssured.given();
	
	Response response = request.delete("/delete/1");
	
	System.out.println("Status : "+response.getStatusCode());
	//Assert.assertEquals(response.getStatusCode(), 200);
	
	ResponseBody body = response.getBody();
	
	//System.out.println("Response Body is: " + body.asString());
	Assert.assertEquals(body, "\"message\":\"Successfully! Record has been deleted\"");
}
}
