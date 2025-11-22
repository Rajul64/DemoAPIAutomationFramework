package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetUserProfileTest {
	
	@Test(description = "Verify get user profile API is working...")
	public void GetUserProfile()
	{
		//call the Authentication service API
		AuthService authService = new AuthService();
		Response response = authService.Login(new LoginRequest("Ram1234567","Ram1234567"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.print(loginResponse.getToken());
		
		//calling the getUserProfile details API
		UserManagementService usrMgmtService = new UserManagementService();
		response  = usrMgmtService.getUserProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class); //convert response JSON object into Java object of UserProfileResponse class
		System.out.println(userProfileResponse.getUsername());
		
		Assert.assertEquals(userProfileResponse.getUsername(), "Ram1234567");
		
		//response: This is likely an object representing an HTTP response, possibly from a REST API call.
		// .as(UserProfileResponse.class): This method converts or deserializes the response body into an instance of the UserProfileResponse class.
		// UserProfileResponse userProfileResponse = ...: This assigns the deserialized object to a variable named userProfileResponse.
		
		//It takes the raw response (probably JSON or XML) and maps it to a Java object of type UserProfileResponse, 
		//making it easier to work with structured data like user name, email, etc., using getters and setters.
			
	}

}
