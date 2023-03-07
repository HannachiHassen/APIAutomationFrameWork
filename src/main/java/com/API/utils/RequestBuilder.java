package com.API.utils;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public final class RequestBuilder {
	
	private RequestBuilder() {
		
	}
	
	public static RequestSpecification buildRequestForGetCalls() {
		return given()
				.baseUri("http://localhost:3000")
				.log()
				.all();
	}
	
	public static RequestSpecification buildRequestForPostCalls() {
		return buildRequestForGetCalls()
				.contentType(ContentType.JSON);
	}
}
