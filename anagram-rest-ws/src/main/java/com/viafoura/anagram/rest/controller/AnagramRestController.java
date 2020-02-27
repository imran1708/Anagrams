package com.viafoura.anagram.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viafoura.anagram.rest.exception.AnagramException;
import com.viafoura.anagram.rest.model.CompareAnagramResult;
import com.viafoura.anagram.rest.model.PermuteAnagramsResult;
import com.viafoura.anagram.rest.service.AnagramService;

/**
 * @author imran Date 26-02-2020
 * 
 *         This class is the main controller from where the REST requests are
 *         served.
 *
 */
@RestController
@RequestMapping("/")
public class AnagramRestController {

	@Autowired
	AnagramService anagramService;

	/**
	 * @param string1
	 * @param string2
	 * @return
	 * @throws Exception
	 * 
	 *                   This method compares if the provided strings are anagrams
	 *                   and returns true or false. It returns Bad request if either
	 *                   of provided string is invalid.
	 */
	@GetMapping("/anagrams/{string1}/{string2}")
	public CompareAnagramResult getAnagramsComparision(@PathVariable String string1, @PathVariable String string2)
			throws AnagramException {
		return anagramService.validateAndCompareAnagram(string1, string2);
	}

	/**
	 * @param string1
	 * @return
	 * @throws Exception
	 * 
	 *                   This method permutes all the possible combinations of the
	 *                   given string that can form anagram to the input and return
	 *                   all the combinations as List. It returns Bad request if the
	 *                   string is invalid.
	 */
	@GetMapping("/anagrams/{string1}")
	public PermuteAnagramsResult getAnagramsPermutation(@PathVariable String string1) throws AnagramException {
		return anagramService.validateAndPermuteAnagram(string1);
	}
}
