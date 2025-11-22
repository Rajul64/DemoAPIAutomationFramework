package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.UserProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateUserProfileTest {
	
	
	@Test(description = "Update user profile")
	public void UpdateProfileInfo()
	{	
		//call Authentication service
		AuthService authService = new AuthService();
		Response response  = authService.Login(new LoginRequest("Ram1234567","Ram1234567"));
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse  = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		System.out.println(".....................................................................");
		
		//call the GetUserProfile API
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getUserProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		Assert.assertEquals(userProfileResponse.getUsername(), "Ram1234567");
		
		System.out.println(".....................................................................");
		
		UserProfileRequest profileRequest = new UserProfileRequest.Builder()
				.firstName("John")
				.lastName("Dare")
				.email("john@gmail.com")
				.mobileNumber("7777777771")
				.build();
		
		//Call the UserProfileUpdate API
		response = userManagementService.updateUserProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
		
	}

}
