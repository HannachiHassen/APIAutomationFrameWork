package com.API.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ProportyUtils {

	private ProportyUtils() {	}
	
	private static Properties property=new Properties();
	private static Map<String, String> MAP= new HashMap<>();
	
	/**
	 * Read the content from property file and store it in HashMap
	 * Read the content only once and store it in some java collection
	 */
	
	static {
		try {
			FileInputStream file=new FileInputStream (System.getProperty("user.dir")+ "/Config File/config.proporties");
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 //finally --> close the input stream connection
		property.entrySet().forEach(e-> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
		
		/**
		 * for(Map.Entry<Object, Object> temp: property.entrySet()) {
		 
			String key= String.valueOf(temp.getKey());
			String value=String.valueOf(temp.getValue());
			MAP.put(key, value);
		}
		*/
	}
	
	public static void readPropertyFileAndStoreInMap() {
		
	}

}
