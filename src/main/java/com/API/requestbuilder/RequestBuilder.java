package com.API.requestbuilder;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import com.API.utils.ProportyUtils;

public final class RequestBuilder {
	
	private RequestBuilder() {
		
	}
	
	public static RequestSpecification buildRequestForGetCalls() {
		return given()
				.baseUri(ProportyUtils.getValue(""))
				.log()
				.all();
	}
	
	public static RequestSpecification buildRequestForPostCalls() {
		return buildRequestForGetCalls()
				.contentType(ContentType.JSON);
	}
}
