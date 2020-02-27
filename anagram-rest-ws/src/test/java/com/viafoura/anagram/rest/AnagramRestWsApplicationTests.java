package com.viafoura.anagram.rest;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.viafoura.anagram.rest.controller.AnagramRestController;
import com.viafoura.anagram.rest.exception.AnagramException;
import com.viafoura.anagram.rest.model.CompareAnagramResult;
import com.viafoura.anagram.rest.model.PermuteAnagramsResult;

@RunWith(SpringRunner.class)
@WebMvcTest(AnagramRestController.class)
class AnagramRestWsApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private AnagramRestController anagramRestController;

	@Test
	void badRequestTest() throws Exception {
		given(anagramRestController.getAnagramsComparision("m@ry", "a@my")).willThrow(AnagramException.class);

		mvc.perform(get("/anagrams/m@ry/a@my").contentType(APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void compareAnagramsTest() throws Exception {
		CompareAnagramResult anagramResult = new CompareAnagramResult();
		anagramResult.setAreAnagrams(true);

		given(anagramRestController.getAnagramsComparision("mary", "army")).willReturn(anagramResult);

		mvc.perform(get("/anagrams/mary/army").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("areAnagrams", is(true)));
	}

	@Test
	void permuteAnagramsTest() throws Exception {
		PermuteAnagramsResult anagramResult = new PermuteAnagramsResult();
		List<String> list = new ArrayList<String>();
		list.add("amry");
		list.add("army");
		list.add("arym");
		list.add("amry");
		list.add("mray");
		list.add("mrya");
		list.add("rmay");
		list.add("mray");
		list.add("mayr");
		list.add("ymar");
		list.add("myar");
		list.add("mayr");
		anagramResult.setAnagrams(list);

		given(anagramRestController.getAnagramsPermutation("mary")).willReturn(anagramResult);

		List<String> list1 = new ArrayList<String>();
		list1.add("amry");
		list1.add("army");
		list1.add("arym");
		list1.add("amry");
		list1.add("mray");
		list1.add("mrya");
		list1.add("rmay");
		list1.add("mray");
		list1.add("mayr");
		list1.add("ymar");
		list1.add("myar");
		list1.add("mayr");

		mvc.perform(get("/anagrams/mary").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("anagrams", is(list1)));
	}

}
