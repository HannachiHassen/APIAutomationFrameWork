package com.API.constants;

import lombok.Getter;


public final class FrameworkConstants {
	/**
	 * if non static --> Class level
	 * 
	 * static --> 
	 */
	private static @Getter final String REQUESTJSON_FOLDER_PATH= System.getProperty("user.dir") + "/Jsons/request.json";
	
	private static @Getter final String RESPONSEJSON_FOLDER_PATH= System.getProperty("user.dir") + "/output/";
	
	private static @Getter final String PROPERTY_CONFIG_PATH= System.getProperty("user.dir") + "/Config/config.properties";

}
