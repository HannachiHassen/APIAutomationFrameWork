package com.API.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

	private FakerUtils() {
	}

	public static final Faker faker=new Faker();
	
	static int getNubmer (int startvalue, int endvalue) {
		return faker.number().numberBetween(startvalue, endvalue);		
	}
	
	static String getFirstName () {
		return faker.name().firstName().toLowerCase();
	}
	
	static String getLastName () {
		return faker.name().lastName().toLowerCase();
	}
}
