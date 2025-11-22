package com.api.base;

import java.util.HashMap;

import com.api.model.request.ForgotPasswordRequest;
import com.api.model.request.LoginRequest;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String Base_Path = "/api/auth/";
	
	public Response Login(LoginRequest payload) //login method
	{
		return PostRequest(payload, Base_Path +"login");
	}
	
	public Response SignUp(SignUpRequest payload) //login method
	{
		return PostRequest(payload, Base_Path +"signup");
	}
	
	/*public  Response ForgotPassword(ForgotPasswordRequest payload)
	{
		return PostRequest(payload, Base_Path +"forgot-password");
	}*/
	
	//another way to call forgotPassword API without creating POJO class model
	
	public  Response ForgotPassword(String emailAddress)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", emailAddress);
		return PostRequest(map, Base_Path + "forgot-password");
	}
	
	

}
