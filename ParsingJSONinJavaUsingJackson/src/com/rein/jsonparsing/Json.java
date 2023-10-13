package com.rein.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {

	private static ObjectMapper objectMapper = getDefaultObejectMapper();

	private static ObjectMapper getDefaultObejectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();

		// Handles if there are multiple fields in the JSON file
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		// Leading the module for handling LocalDate objects
		defaultObjectMapper.registerModule(new JavaTimeModule());

		return defaultObjectMapper;
	}

	// Converts String to JsonNode
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readTree(src);
	}

	// Converts JsonNode to a class / object
	public static <A> A fromJson(JsonNode jsonNode, Class<A> jsonClass)
			throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(jsonNode, jsonClass);
	}

	// Converts and Object to a JsonNode
	public static JsonNode toJson(Object jsonObject) {
		return objectMapper.valueToTree(jsonObject);
	}

	// Converts JsonNode to a String
	public static String stringify(JsonNode jsonNode) throws JsonProcessingException {
		return generateString(jsonNode, false);
	}

	// Converts JsonNode to a String in a better format
	public static String prettyPrint(JsonNode jsonNode) throws JsonProcessingException {
		return generateString(jsonNode, true);
	}

	// Generates a formatted Json String, depending if formatString is true or false
	private static String generateString(JsonNode jsonNode, boolean formatString) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		if (formatString) {
			objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		}
		return objectWriter.writeValueAsString(jsonNode);
	}

}
