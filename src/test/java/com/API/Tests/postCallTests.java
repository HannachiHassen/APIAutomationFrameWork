package com.API.Tests;

import static io.restassured.RestAssured.given;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.API.pojo.Employee;
import static com.API.utils.RandomUtils.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public final class postCallTests {

	public postCallTests() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void postCallTest() {
		Employee employee=Employee
				.builder()
				.setId(getId())
				.setFname(getFname())
				.setLname(getLname())
				.build();
		
		Response response=given().baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.header("",ContentType.JSON)
		.log()
		.all()
		.body(employee)
		.post("/employees");
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);		
	}
}
