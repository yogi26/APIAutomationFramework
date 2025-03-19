package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL="http://64.227.160.186:8080/";
	
	private RequestSpecification requestSpecification;
	
	static
	{
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {
		requestSpecification=given().baseUri(BASE_URL); 
	}
	protected Response postRequest(Object payload, String endpoint) {
		
		return requestSpecification
				.contentType(ContentType.JSON)
				.body(payload)
				.post(endpoint);
	}
	protected Response getRequest(String endpoint) {
		
		return requestSpecification
				.contentType(ContentType.JSON)
				.get(endpoint);
	}
	protected void setAuthToken(String token) {
		
		requestSpecification
				.header("Authorization","Bearer "+token);
	}
	protected Response putRequest(Object body, String endpoint) {
		
		return requestSpecification
				.contentType(ContentType.JSON)
				.body(body)
				.put(endpoint);
	}
}
