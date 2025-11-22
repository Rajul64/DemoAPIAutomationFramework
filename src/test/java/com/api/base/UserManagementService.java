package com.api.base;

import com.api.model.request.UserProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{
	
	
	private static final String Base_Path = "/api/users";
	
	public Response getUserProfile(String token) //get method
	{
		setAuthToken(token); //Internally call the setAuthToken method
		return getRequest(Base_Path+"/profile");
	}
	
	
	public Response updateUserProfile(String token, UserProfileRequest payload) //Pass the authorization token and payload
	{
		setAuthToken(token); //will set the Auth token here
		return putRequest(payload, Base_Path+"/profile"); //internally call the PuRequest method
	}

}
