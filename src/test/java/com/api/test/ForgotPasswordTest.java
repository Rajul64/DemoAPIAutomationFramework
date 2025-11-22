package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.ForgotPasswordRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description = "Verify if the forgot-password API is working...")
	public void ForgotPWD()
	{
		//ForgotPasswordRequest forgotPwdRequest = new ForgotPasswordRequest("rajulg71@gmail.com"); //Create an object of ForgotPasswordRequest model POJO class
		AuthService authService = new AuthService();
		Response response = authService.ForgotPassword("rajulg71@gmail.com");
		System.out.println(response.asPrettyString());
		
		//Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive reset instructions.");
		
		
	}
	
	
	
	
	
	
	
	

}
