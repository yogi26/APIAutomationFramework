package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest() {
		
		Response response = new AuthService().login(new LoginRequest("yogesh123", "yogesh123"));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		response.prettyPrint();
		
		UserProfileManagementService managementService=new UserProfileManagementService();
		
		Response profileResponse = managementService.getProfile(token);
		profileResponse.prettyPrint();
		
		ProfileRequest profileRequest=new ProfileRequest.Builder()
				.firstName("Yogi")
				.lastName("Giri")
				.email("yogeshgiri@gmail.com")
				.mobileNumber("8877665555")
				.build();
				
		Response profileResponse1=managementService.updateProfile(token, profileRequest);
		profileResponse1.asPrettyString();
	}
}
