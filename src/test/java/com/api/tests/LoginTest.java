package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.MyTestListener.class)
public class LoginTest {
	
	@Test(description="verify if the api login is working..")
	public void loginTest() {
		LoginRequest loginRequest=new LoginRequest("yogesh123", "yogesh123");
		AuthService authService=new AuthService();
		Response response = authService.login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		assertEquals(loginResponse.getEmail(), "yogeshgiri@gmail.com");
		assertEquals(response.getStatusCode(), 200);
		
	}
}
