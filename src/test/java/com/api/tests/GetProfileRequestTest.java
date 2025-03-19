package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test
	public void getProfileInfoTest() {
		
		Response res=new AuthService().login(new LoginRequest("yogesh123","yogesh123"));
		LoginResponse loginResponse= res.as(LoginResponse.class);
		
		UserProfileManagementService profileManagementService=new UserProfileManagementService();
		Response response=profileManagementService.getProfile(loginResponse.getToken());
		
		UserProfileResponse profileResponse=response.as(UserProfileResponse.class);
		System.out.println(profileResponse);
	}
}
