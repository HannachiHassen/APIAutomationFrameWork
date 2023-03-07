package com.API.Tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.API.constants.FCwithSingleton;
import com.API.pojo.Employee;
import com.API.requestbuilder.RequestBuilder;
import com.API.utils.ApiUtils;

import static com.API.utils.RandomUtils.*;

import java.lang.reflect.Method;

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
	public void postRequestUsingExtrnalFile(Method method) {
		String resource=ApiUtils
				.readJsonAndGetAsString(FCwithSingleton.getInstance() + method.getName())
				.replace("fname", RandomUtils.getFirstname())
				.replace("id", String.valueOf(getId()));
		
		Response response=RequestBuilder
				.buildRequestForPostCalls()
				.body(resource)
				.post("/employees");
		response.prettyPrint();
		
		ApiUtils.storeStringAsJson(FCwithSingleton.getInstance() + method.getName()+ "response.json", response);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);		
	}
}
