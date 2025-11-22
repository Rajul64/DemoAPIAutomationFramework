package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "verify if AccountCreation API is working...")
	public void createAccountTest()
	{
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.userName("Ram1234567")
		.email("ram000123@gmail.com")
		.password("Ram1234567")
		.firstName("Ramg1")
		.lastName("Gupta")
		.mobileNumber("7474747470")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.SignUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
	}

}
