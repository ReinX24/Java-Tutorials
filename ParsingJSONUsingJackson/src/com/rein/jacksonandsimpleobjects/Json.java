package com.rein.jacksonandsimpleobjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {

	private static ObjectMapper objectMapper = getDefaultObjectMapper();

	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();

		// Configuring our ObjectMapper to take into multiple data types
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return defaultObjectMapper;
	}

	// This method accepts a JSON String as a parameter
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {

		return objectMapper.readTree(src);

	}

	// Method that converts Json into an object
	public static <A> A fromJson(JsonNode node, Class<A> returnClass)
			throws JsonProcessingException, IllegalArgumentException {

		return objectMapper.treeToValue(node, returnClass);

	}

	// Method that convert an Object to a JsonNode
	public static JsonNode toJson(Object a) {

		return objectMapper.valueToTree(a);

	}

	// Method for converting a JsonNode to a String
	public static String convertJsonString(JsonNode node) throws JsonProcessingException {

		return generateString(node, false);

	}

	public static String convertJsonStringPretty(JsonNode node) throws JsonProcessingException {

		return generateString(node, true);

	}

	private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {

		ObjectWriter objectWriter = objectMapper.writer();
		if (pretty) {
			objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		}
		return objectWriter.writeValueAsString(node);

	}

}
