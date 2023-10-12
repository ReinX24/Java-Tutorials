package com.rein.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonTestMain {

	public static void main(String[] args) {

		String jsonSource = "{\"title\": \"Coder From Scratch\"}";

		try {

			JsonNode jsonNode = Json.parse(jsonSource);
			
			System.out.println(jsonNode.get("title").asText());

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
