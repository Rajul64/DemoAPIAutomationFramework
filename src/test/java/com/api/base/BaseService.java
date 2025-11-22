package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.model.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //wrapper over Rest Assured !! so that we can introduce abstraction
	//Base Uri
	//handling response
	//Creating Request
	
	
	  private static final String BASE_URL = "http://64.227.160.186:8080";          
	  private RequestSpecification requestSpecification;
	  
	 static {
		  RestAssured.filters(new LoggingFilter());
	  }
	  
	  
	  public BaseService() { //constructor
		  
		  requestSpecification = given().baseUri(BASE_URL);
	  }
	  
	  protected Response PostRequest(Object payload, String endpoint)
	  {
		  return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		  
	  }
	  
	  protected void setAuthToken(String token)
	  {
		  requestSpecification.header("Authorization", "Bearer "+token);
	  }
	  
	  protected Response getRequest(String endpoint)
	  {
		  return requestSpecification.get(endpoint);
	  }
	  
	  //Put request
	  protected Response putRequest(Object payload, String endpoint)
	  {
		  return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	  }
}
