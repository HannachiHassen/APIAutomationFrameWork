package com.API.Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class DataProviderTest {

	public DataProviderTest() {	}
	
	/**
	 * Object[][] is not always the return type
	 * number of tests will be one if we use for loop
	 * 
     */
	
	@Test(dataProvider = "getData")
	public void dbTest(String username, String pasword) {			
			System.out.println(username);
			System.out.println("password= " +pasword);			
	}
	
	@DataProvider
    public Object[][] getData1(){
		Object[][] data= new Object[3][1];
		Map<String,String> map1 = new HashMap<>();
		map1.put("username","sdfsf");
        map1.put("password","sdfsffghf");
        map1.put("email","sdfsffdhdf");
        
        
		return data;
	}
	
	/**
	 * first dim basically number of times you want to execute
	 * second dim indicates number of parameters to the method
	 */
	@DataProvider
	public Object [][] getData(){
		
		return new Object [][] {
			{"abcd","test"},
			{"efgsh", "test2"},
			{"ijkl", "test3"}
		};		
	}
}
