package com.API.constants;

import lombok.Getter;

@Getter
public final class FCwithSingleton {
	
	private FCwithSingleton() {	}
	
	private static FCwithSingleton INSTANCE=null;
	
	/**
	 * Single ton--> Single instance for an class at a particular point of time creational design pattern
	 */
	
	public static synchronized FCwithSingleton getInstance(){ //10 threads
        if(INSTANCE==null){
            INSTANCE=new FCwithSingleton();
        }
        return INSTANCE;
    }

    private  final String requestJsonFolderpath = System.getProperty("user.dir") + "/Jsons/";
    private  final String responseJsonFolderPath = System.getProperty("user.dir") + "/output/";
}
