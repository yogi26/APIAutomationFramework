package com.api.base;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	
	private final static String BASE_PATH="/api/users/";
	
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"profile");
	}
	
	public Response updateProfile(String token, ProfileRequest body) {
		setAuthToken(token);
		return putRequest(body, BASE_PATH+"profile");
	}
}
