package com.API.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.SneakyThrows;

public final class ApiUtils {

	private ApiUtils() {
	}

	@SneakyThrows
	public static String readJsonAndGetAsString(String filepath) {
		return new String(Files.readAllBytes(Paths.get(filepath)));		
	}
}
