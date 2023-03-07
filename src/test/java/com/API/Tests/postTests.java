package com.API.Tests;

import com.API.constants.FCwithSingleton;
import com.API.pojo.Employee;

import com.API.requestbuilder.RequestBuilder;
import com.API.utils.ApiUtils;
import com.API.utils.RandomUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.API.constants.FCwithSingleton.getInstance;
import static com.API.utils.RandomUtils.*;

public final class postTests {

	private postTests() {		
	}
	
	@Test
	public void postCallTest() {
		Employee employee=Employee
				.builder()
				.setId(getId())
				.setFname(getFirstName())
				.setLname(getLastName())
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
				.readJsonAndGetAsString(
						FCwithSingleton.getInstance().getRequestJsonFolderpath() + "request.json")
				.replace("fname", RandomUtils.getFirstName())
				.replace("id", String.valueOf(getId()));  // arrange
		
		Response response=RequestBuilder
				.buildRequestForPostCalls()
				.body(resource)
				.post("/employees");
		response.prettyPrint();  //actions
		
		ApiUtils.storeStringAsJsonFile(FCwithSingleton.getInstance() + method.getName()+ "response.json", response);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);	//assertions
	}
	
	public void postRequestUsingExternalFile1(Method method){ //throws IOEXception
	        String resource = ApiUtils
	                .readJsonAndGetAsString(
	                        getInstance().getRequestJsonFolderpath() +"request.json")
	                .replace("fname", RandomUtils.getFirstName())
	                .replace("id",String.valueOf(RandomUtils.getId())); //arrange
	        //Interface
	        

	        RequestSpecification requestSpecification = RequestBuilder
	                .buildRequestForPostCalls()
	                .body(resource);
	        Response response = requestSpecification.post("/employees");
	        response.prettyPrint(); //actions
	       

	        ApiUtils
	                .storeStringAsJsonFile(getInstance()
	                .getResponseJsonFolderPath() + method.getName() + "response.json", response);
	        //response schema validation
	        Assertions.assertThat(response.getStatusCode()).isEqualTo(201); //assertions
   }
}
