package com.viafoura.codingchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Anagram {

	public static Boolean isAnagram(String string1, String string2) {
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
}
