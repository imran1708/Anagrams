package com.viafoura.codingchallenge;

import junit.framework.TestCase;

/**
 * Unit test for Anagram App.
 */
public class AnagramTest extends TestCase {

	/**
	 * Testing is anagram and case sensitivity
	 */
	public void testAnagram1() {
		assertTrue(Anagram.isAnagram("Mary", "Army"));
	}

	/**
	 * Testing is anagram and case sensitivity
	 */
	public void testAnagram2() {
		assertTrue(Anagram.isAnagram("Iceman", "cinema"));
	}

	/**
	 * Testing is anagram and same string
	 */
	public void testAnagram3() {
		assertTrue(Anagram.isAnagram("coal", "coal"));
	}

	/**
	 * Testing is anagram and case sensitivity
	 */
	public void testAnagram4() {
		assertTrue(Anagram.isAnagram("sTew", "weSt"));
	}

	/**
	 * Testing is anagram and case sensitivity
	 */
	public void testAnagram5() {
		assertTrue(Anagram.isAnagram("CHEAP", "PEACH"));
	}

	/**
	 * Testing is not anagram
	 */
	public void testAnagram6() {
		assertFalse(Anagram.isAnagram("may", "mary"));
	}

	/**
	 * Testing is not anagram and case sensitivity
	 */
	public void testAnagram7() {
		assertFalse(Anagram.isAnagram("Cool", "cOAl"));
	}

	/**
	 * Testing is not anagram and special character
	 */
	public void testAnagram8() {
		assertFalse(Anagram.isAnagram("@", "@"));
	}

	/**
	 * Testing is not anagram and empty string
	 */
	public void testAnagram9() {
		assertFalse(Anagram.isAnagram("", ""));
	}

	/**
	 * Testing is anagram with number
	 */
	public void testAnagram10() {
		assertTrue(Anagram.isAnagram("1234", "4321"));
	}
}
