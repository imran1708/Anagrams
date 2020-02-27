package com.viafoura.anagram.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viafoura.anagram.rest.model.CompareAnagramResult;
import com.viafoura.anagram.rest.model.PermuteAnagramsResult;
import com.viafoura.anagram.rest.service.AnagramService;

@RestController
@RequestMapping("/")
public class AnagramRestController {

	@Autowired
	AnagramService anagramService;

	@GetMapping("/anagrams/{string1}/{string2}")
	public CompareAnagramResult getAnagramsComparision(@PathVariable String string1, @PathVariable String string2)
			throws Exception {
		return anagramService.validateAndCompareAnagram(string1, string2);
	}

	@GetMapping("/anagrams/{string1}")
	public PermuteAnagramsResult getAnagramsPermutation(@PathVariable String string1) throws Exception {
		return anagramService.validateAndPermuteAnagram(string1);
	}
}
