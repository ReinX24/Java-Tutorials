package com.rein.jacksonandsimpleobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.rein.jacksonandsimpleobjects.pojo.SimpleTestCaseJsonPOJO;

class JsonTest {

	private String testCaseOne = "{\"joke\": \"Why did the twinkie go to the dentist? He lost his filling!\", \"author:\": \"Jokes API\"}";
	private String testCaseTwo = "{\"name\": \"Rein\"}";

	@Test
	void testParse() throws JsonMappingException, JsonProcessingException {

		JsonNode jsonNodeOne = Json.parse(testCaseOne);
		assertEquals(jsonNodeOne.get("joke").asText(), "Why did the twinkie go to the dentist? He lost his filling!");

		JsonNode jsonNodeTwo = Json.parse(testCaseTwo);
		assertEquals(jsonNodeTwo.get("name").asText(), "Rein");

	}

	@Test
	void fromJson() throws JsonProcessingException, IllegalArgumentException {

		JsonNode jsonNodeOne = Json.parse(testCaseOne);
		SimpleTestCaseJsonPOJO pojoOne = Json.fromJson(jsonNodeOne, SimpleTestCaseJsonPOJO.class);
		assertEquals(pojoOne.getJoke(), "Why did the twinkie go to the dentist? He lost his filling!");
//		System.out.println("POJO Title: " + pojoOne.getJoke());

	}

	@Test
	void toJson() {
		SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
		pojo.setJoke("What do you call a fish with no eye? A fshhhhhh");

		JsonNode jsonNode = Json.toJson(pojo);
		assertEquals(jsonNode.get("joke").asText(), "What do you call a fish with no eye? A fshhhhhh");
	}

	@Test
	void convertJsonNodeToString() throws JsonProcessingException {

		SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
		pojo.setJoke("What do you call a fish with no eye? A fshhhhhh");

		JsonNode jsonNode = Json.toJson(pojo);

		String jsonString = Json.convertJsonString(jsonNode);
		System.out.println(jsonString);

		jsonString = Json.convertJsonStringPretty(jsonNode);
		System.out.println(jsonString);

	}

}
