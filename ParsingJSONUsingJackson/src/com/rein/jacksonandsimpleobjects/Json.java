package com.rein.jacksonandsimpleobjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	private static ObjectMapper objectMapper = getDefaultObjectMapper();

	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		return defaultObjectMapper;
	}

	// This method accepts a JSON Strign as a parameter
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {

		return objectMapper.readTree(src);

	}

}
