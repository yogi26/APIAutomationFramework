package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUpTest {
	@Test
	public void signUp() {
		SignUpRequest signUpRequest=new SignUpRequest("stream1", "stream1", "stream1@gmail.com", "test", "test", "6767656543");
		AuthService service=new AuthService();
		Response response = service.signUp(signUpRequest);
		response.prettyPrint();
	}
}
