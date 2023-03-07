package com.API.Tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.API.pojo.Employee;
import com.API.utils.RequestBuilder;
import com.API.utils.ApiUtils;

import static com.API.utils.RandomUtils.*;
import io.restassured.response.Response;
import com.API.utils.RandomUtils;


public final class postCallTests {

	public postCallTests() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void postCallTest() {
		Employee employee=Employee
				.builder()
				.setId(getId())
				.setFname(getFirstname())
				.setLname(getLastname())
				.build();
		
		Response response=RequestBuilder
				.buildRequestForPostCalls()
				.body(employee)
				.post("/employees");
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);		
	}
	
	@Test
	public void postRequestUsingExtrnalFile() {
		String resource=ApiUtils
				.readJsonAndGetAsString(System.getProperty("user.dir" + "./Jsons/request.json"))
				.replace("fname", RandomUtils.getFirstname())
				.replace("id", String.valueOf(getId()));
		
		Response response=RequestBuilder
				.buildRequestForPostCalls()
				.body(resource)
				.post("/employees");
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);		
	}
}
