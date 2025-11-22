package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	


	@Test(description = "Verify if Login API is working...")
	public void LoginTest()
	{
		
		Response response = RestAssured.given().baseUri("http://64.227.160.186:8080").
		header("content-type", "application/json"). 
		body("{username: \"rajulgupta\", password: \"Pasword#123\"}").
	    when().post("/api/auth/login");  //end point
	    System.out.println(response.asPrettyString());
	    
	    Assert.assertEquals(response.getStatusCode(), 500);
	}

}
