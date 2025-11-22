package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginAPITest2 {
	
	
	@Test(description = "Verify if login test api is working")
	public void loginTest()
	{
		Response response = RestAssured.given().baseUri("http://64.227.160.186:8080")
		
		.header("content-type", "application/json")
		.body("{username: \"rajulgupta\", password: \"Pasword#123\"}")
		.post("/api/auth/login");		
		System.out.println(response.asPrettyString());
	    
	    Assert.assertEquals(response.getStatusCode(), 500);
	}

}
