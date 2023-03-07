package com.API.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.API.constants.FrameworkConstants;
import com.API.enums.PropertiesType;

public final class ProportyUtils {

	private ProportyUtils() {	}
	
	/**
	 * Read the content from property file and store it in HashMap
	 * Read the content only once and store it in some java collection
	 */
	private static Properties property=new Properties();
	private static Map<String, String> MAP= new HashMap<>();	
	
	/**
	 * Generic exception , some one has to make a call 
	 * incorrect exception is propagated to caller before the whole test execution starts
	 */
	static {
		try(FileInputStream inputstream=new FileInputStream (FrameworkConstants.getPROPERTY_CONFIG_PATH())){
			property.load(inputstream);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/**
		* finally --> Close the input stream connection
		*/
		property.entrySet().forEach(e-> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));	
	}
	
	public static String getValue (PropertiesType key) {
		return MAP.get(key.name().toLowerCase());
	}
	
	/**
	 * for(Map.Entry<Object, Object> temp: property.entrySet()) {
	 
		String key= String.valueOf(temp.getKey());
		String value=String.valueOf(temp.getValue());
		MAP.put(key, value);
	}
	*/

}
