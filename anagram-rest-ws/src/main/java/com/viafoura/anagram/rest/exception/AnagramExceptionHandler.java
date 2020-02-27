package com.viafoura.anagram.rest.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author imran Date 26-02-2020
 * 
 *         This is an Exception handler class to return bad request in case if
 *         invalid string. If this is not present the response would be 505
 *         error.
 */
@ControllerAdvice
public class AnagramExceptionHandler {

	/**
	 * @param response
	 * @throws IOException
	 * 
	 *                     This method returns 400 error as response when
	 *                     AnagramException occurs in the application.
	 */
	@ExceptionHandler(AnagramException.class)
	public void invalidAnagramInout(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
