package com.api.test;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListners.class)
public class LoginAPITest3 {
	
	
	@Test(description = "Verify if login test API is working")
	public void loginTest()
	{
		LoginRequest loginRequest = new LoginRequest("ra1234","ra1234");
		AuthService authService = new AuthService();
		Response response = authService.Login(loginRequest);
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		// as - convert the JSON object which is coming in the response into Java object of 
		//LoginResponse and store it into the reference variable of LoginResponse
		
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getType());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getRoles());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getUsername(), "ra1234");
		Assert.assertEquals(loginResponse.getEmail(), "raja2@gmail.com");
	}

}
