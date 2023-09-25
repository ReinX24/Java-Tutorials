package com.rein.jacksonandsimpleobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

class JsonTest {

	private String testCaseOne = "{\"joke\": \"Why did the twinkie go to the dentist? He lost his filling!\"}";
	private String testCaseTwo = "{\"name\": \"Rein\"}";

	@Test
	void testParse() throws JsonMappingException, JsonProcessingException {

		JsonNode jsonNodeOne = Json.parse(testCaseOne);
		assertEquals(jsonNodeOne.get("joke").asText(), "Why did the twinkie go to the dentist? He lost his filling!");
		
		JsonNode jsonNodeTwo = Json.parse(testCaseTwo);
		assertEquals(jsonNodeTwo.get("name").asText(), "Rein");

	}

}
