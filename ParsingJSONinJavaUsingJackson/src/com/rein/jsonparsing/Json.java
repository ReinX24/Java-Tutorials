package com.rein.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	private static ObjectMapper objectMapper = getDefaultObejectMapper();

	private static ObjectMapper getDefaultObejectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();

		return defaultObjectMapper;
	}

	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {

		return objectMapper.readTree(src); // converts String to JsonNode

	}
	
	

}
