package com.assignment.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomValueGenerator {
	public static String generateRandomAlphabetesString(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz";
		return RandomStringUtils.random(length, allowedChars).substring(0, length);
	}

	public static String generateRandomNumberString(int length) {
		String allowedChars = "123456789";
		return RandomStringUtils.random(length, allowedChars).substring(0, length);
	}
}
