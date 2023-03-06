package com.API.Tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public final class getTests {
    
	@Test 
	public void getEmployeeDetails() {
		
		Response response=given()
				.baseUri("http://localhost:3000")
				.get("/emmployees");  //class or config.properties		
	}
}
