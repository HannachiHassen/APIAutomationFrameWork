package com.API.Tests;

import static io.restassured.RestAssured.given;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public final class getTests {
    
	@Test 
	public void getEmployeesDetails() {
		
		Response response=given()
				.baseUri("http://localhost:3000")
				.log()
				.all()
				.get("/employees");  //class or config.properties	
		response.prettyPrint();
		
		assertThat(response.getStatusCode())
		.isEqualTo(200);
		
		assertThat(response.jsonPath().getList("$").size())
		.isPositive()
		.as("Validating the size of the employee array").isLessThan(30);
	}
	
	@Test 
	public void getEmployeeDetails() {
		
		Response response=given()
				.baseUri("http://localhost:3000")
				.log()
				.all()								
				.pathParam("id", 2)
				.get("/employees/{id}");  //class or config.properties	
		response.prettyPrint();
		
		assertThat(response.getStatusCode())
		.isEqualTo(200);
		
		assertThat(response.jsonPath().getString("last_name"))
		.as("Comparing the last naem node in the response")
		.isNotEmpty()
		.isEqualTo("Eschweiler")
		.hasSizeBetween(3, 20);
	}
}
