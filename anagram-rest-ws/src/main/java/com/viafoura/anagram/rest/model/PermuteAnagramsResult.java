package com.viafoura.anagram.rest.model;

import java.util.List;

public class PermuteAnagramsResult {
	private List<String> anagrams;

	public List<String> getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(List<String> anagrams) {
		this.anagrams = anagrams;
	}
}
