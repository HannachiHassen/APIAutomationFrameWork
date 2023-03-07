package com.API.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ProportiesUtils {

	private ProportiesUtils() {
	}
	
	private static Properties property=new Properties();
	
	static {
		try {
			FileInputStream file=new FileInputStream (System.getProperty("user.dir")+ "./Config File/config.proporties");
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
