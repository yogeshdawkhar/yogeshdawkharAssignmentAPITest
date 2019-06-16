package com.assignment.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	static Properties prop = new Properties();

	public static void load(String propertyFilePath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (Exception e) {
			System.out.println("Configuration file is not found. terminating Process !!!");
			System.exit(0);
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static String get(String key) {

		String propertyFileValue = null;

		if (!prop.isEmpty()) {
			propertyFileValue = prop.getProperty(key);

		} else {
			System.out.println("Configuration file is empty. Processing is terminated");
			System.exit(0);
		}

		return propertyFileValue;

	}
}
