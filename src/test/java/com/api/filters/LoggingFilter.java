package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx)
	{	
		//Log Request
		logRequest(requestSpec);
		
		Response response = ctx.next(requestSpec, responseSpec); //Request is going to execute
		
		//Log Response
		logResponse(response);
		return response; // test for assertion
	}
	
	
	public void logRequest(FilterableRequestSpecification requestSpec)
	{
		logger.info("Request Base URL: " + requestSpec.getBaseUri());
		logger.info("Request Header: " + requestSpec.getHeaders());
		logger.info("Request Payload: " + requestSpec.getBody());
	}
	
	
	public void logResponse(Response response)
	{
		logger.info("Response StatusCode: " + response.getStatusCode());
		logger.info("Response Body: " + response.getBody().prettyPrint());
		logger.info("Response Header: " + response.headers());
	}

}
