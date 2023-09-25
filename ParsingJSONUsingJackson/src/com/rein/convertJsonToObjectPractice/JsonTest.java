package com.rein.convertJsonToObjectPractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

class JsonTest {

	String testOne = "{\"joke\":\"What do you call a singing laptop? A Dell!\"}";
	String testTwo = "{\"name\":\"rein\"}";
	String testThree = "{\"agent\":\"Jett\"}";
		
	@Test
	void testParse() throws JsonMappingException, JsonProcessingException {
		
		assertEquals(Json.parse(testOne).get("joke").asText(), "What do you call a singing laptop? A Dell!");
		System.out.println("Test One Passed!");
		
		assertEquals(Json.parse(testTwo).get("name").asText(), "rein");
		System.out.println("Test Two Passed!");
		
		assertEquals(Json.parse(testThree).get("agent").asText(), "Jett");
		System.out.println("Test Three Passed!");
		
		
	}

}
