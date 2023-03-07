package com.API.utils;

public final class RandomUtils {

	private RandomUtils() {		
	}
	
	public static int getId() {
		return FakerUtils.getNubmer(100, 1000);	
	}
	
	public static String getFname() {
		return FakerUtils.getFirstName();
	}
	
	public static String getLname() {
		return FakerUtils.getLastName();
	}

}
