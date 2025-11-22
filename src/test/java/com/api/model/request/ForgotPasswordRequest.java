package com.api.model.request;

public class ForgotPasswordRequest {
	
	private String email; //global variable
	
	
	public ForgotPasswordRequest(String email) //local variable
	{
		super();
		this.email = email;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "ForgotPasswordTest [email=" + email + "]";
	}

}
