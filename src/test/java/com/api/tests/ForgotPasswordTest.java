package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPasswordTest() {
		Response res=new AuthService().forgotPassword("test120@gmail.com");
		res.prettyPrint();
	}
}
