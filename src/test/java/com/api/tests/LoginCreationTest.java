package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class LoginCreationTest {
	
	@Test
	public void createAccountTest() {
		SignUpRequest request = new SignUpRequest
			.Builder()
				.userName("temp120")
				.email("test120@gmail.com")
				.firstName("test")
				.lastName("test")
				.password("temp11")
				.mobileNumber("8877665544")
				.build();
		
		AuthService service=new AuthService();
		Response res=service.signUp(request);
		res.prettyPrint();
		assertEquals(res.asPrettyString(), "User registered successfully!");
	}
}
