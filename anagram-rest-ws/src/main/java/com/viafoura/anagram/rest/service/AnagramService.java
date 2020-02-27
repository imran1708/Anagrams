package com.viafoura.anagram.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viafoura.anagram.rest.exception.AnagramExcetion;
import com.viafoura.anagram.rest.model.CompareAnagramResult;
import com.viafoura.anagram.rest.model.PermuteAnagramsResult;
import com.viafoura.anagram.rest.model.PropertiesHolder;
import com.viafoura.anagram.rest.validator.AnagramValidator;

@Service
public class AnagramService {

	@Autowired
	PropertiesHolder propertiesHolder;

	public CompareAnagramResult validateAndCompareAnagram(String string1, String string2) throws AnagramExcetion {
		if (AnagramValidator.validateNotNull(string1) && AnagramValidator.validateNotNull(string2)) {
			AnagramValidator.isValidPattern(getProperties(), string1, string2);
			CompareAnagramResult anagramResult = new CompareAnagramResult();
			anagramResult.setAreAnagrams(isAnagram(string1, string2));
			return anagramResult;
		} else {
			throw new AnagramExcetion(getProperties().getProperty("invalid_input"));
		}
	}

	public PermuteAnagramsResult validateAndPermuteAnagram(String string1) throws AnagramExcetion {
		if (AnagramValidator.validateNotNull(string1)) {
			PermuteAnagramsResult anagramsResult = new PermuteAnagramsResult();
			AnagramValidator.isValidPattern(getProperties(), string1);
			anagramsResult.setAnagrams(permuteAnagrams(string1));
			return anagramsResult;
		} else {
			throw new AnagramExcetion(getProperties().getProperty("invalid_input"));
		}
	}

	public List<String> permuteAnagrams(String string) throws AnagramExcetion {
		List<String> list = new ArrayList<String>();
		if (string.length() > 1) {
			for (int i = 0; i <= string.length() - 1; i++) {
				for (int j = 0; j <= string.length() - 1; j++) {
					StringBuilder builder = new StringBuilder(string);
					char c = builder.charAt(i);
					builder.deleteCharAt(i);
					builder.insert(j, c);

					if (!builder.toString().equalsIgnoreCase(string))
						list.add(builder.toString());
				}
			}
		}
		return list;
	}

	public boolean isAnagram(String string1, String string2) {
		Map<Character, Integer[]> map = new HashMap<Character, Integer[]>();

		if (string1.isEmpty() || string2.isEmpty())
			return false;

		if (string1.length() != string2.length())
			return false;

		if (!Pattern.compile("^[a-zA-Z0-9]+$").matcher(string1).matches()
				|| !Pattern.compile("^[a-zA-Z0-9]+$").matcher(string1).matches())
			return false;

		char[] s1 = string1.toLowerCase().toCharArray();
		char[] s2 = string2.toLowerCase().toCharArray();

		for (int i = 0; i < s1.length; i++) {
			char c = s1[i];
			if (map.containsKey(c)) {
				Integer[] in = map.get(c);
				in[0] = null != in[0] ? in[0] + 1 : 1;
				map.put(c, in);
			} else {
				Integer[] in = new Integer[2];
				in[0] = 1;
				map.put(c, in);
			}
			char c1 = s2[i];
			if (map.containsKey(c1)) {
				Integer[] in = map.get(c1);
				in[1] = null != in[1] ? in[1] + 1 : 1;
				map.put(c1, in);
			} else {
				Integer[] in = new Integer[2];
				in[1] = 1;
				map.put(c1, in);
			}
		}

		for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
			if (entry.getValue()[0] == null && entry.getValue()[1] != null)
				return false;
			else if (!entry.getValue()[0].equals(entry.getValue()[1])) {
				return false;
			}
		}
		return true;
	}

	public Properties getProperties() {
		return propertiesHolder.getProperties();
	}
}
