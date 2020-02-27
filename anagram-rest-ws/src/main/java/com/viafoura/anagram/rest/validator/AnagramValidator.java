package com.viafoura.anagram.rest.validator;

import java.util.Properties;
import java.util.regex.Pattern;

import com.viafoura.anagram.rest.constant.AnagramConstants;
import com.viafoura.anagram.rest.exception.AnagramException;

public class AnagramValidator {

	public static boolean validateNotNull(String string) {
		if (null == string) {
			return false;
		}
		return true;
	}

	public static boolean isValidPattern(Properties properties, String string1) throws AnagramException {
		if (!Pattern.compile(AnagramConstants.CHARACTERS_AND_NUMBERS_REGEX).matcher(string1).matches()) {
			throw new AnagramException(properties.getProperty("invalid_input") + string1);
		}
		return true;
	}

	public static boolean isValidPattern(Properties properties, String string1, String string2)
			throws AnagramException {

		if (!Pattern.compile(AnagramConstants.CHARACTERS_AND_NUMBERS_REGEX).matcher(string1).matches()) {
			throw new AnagramException(properties.getProperty("invalid_input") + string1);
		}

		if (!Pattern.compile(AnagramConstants.CHARACTERS_AND_NUMBERS_REGEX).matcher(string2).matches()) {
			throw new AnagramException(properties.getProperty("invalid_input") + string2);
		}
		return true;
	}
}