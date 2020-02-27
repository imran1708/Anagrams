package com.viafoura.anagram.rest.exception;

/**
 * @author imran Date 26-02-2020
 * 
 *         This is a custom exception class for Anagram application
 *
 */
public class AnagramExcetion extends Exception {

	private static final long serialVersionUID = -5999029811555713038L;

	public AnagramExcetion(String message) {
		super(message);
	}
}
