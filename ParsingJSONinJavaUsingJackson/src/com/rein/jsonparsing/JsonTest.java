package com.rein.jsonparsing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.rein.jsonparsing.pojo.*;

class JsonTest {

	private String simpleTestCase = "{ \n" + "	\"title\": \"Coder From Scratch\", \n" + "	\"author\": \"Rui\" \n"
			+ "}";

	private String dayScenarioOne = "{ \n" + "	\"date\": \"2023-12-25\",\n" + "	\"name\": \"Christmas Day\" \n"
			+ "}";

	private String bookAuthorScenarioOne = "{ \n" + "	\"authorName\": \"Rui\",\n" + "	\"books\": [\n" + "		{\n"
			+ "			\"title\": \"titleOne\",\n" + "			\"inPrint\": true,\n"
			+ "			\"publishDate\": \"2019-12-25\"\n" + "		},\n" + "		{\n"
			+ "			\"title\": \"titleTwo\",\n" + "			\"inPrint\": false,\n"
			+ "			\"publishDate\": \"2020-01-01\"\n" + "		}\n" + "	]\n" + "}";

	@Test
	void parse() throws JsonMappingException, JsonProcessingException {

		JsonNode jsonNode = Json.parse(simpleTestCase);
		assertEquals(jsonNode.get("title").asText(), "Coder From Scratch");

	}

	@Test
	void fromJson() throws JsonProcessingException, IllegalArgumentException {

		JsonNode jsonNode = Json.parse(simpleTestCase);
		SimpleTestCasePOJO pojo = Json.fromJson(jsonNode, SimpleTestCasePOJO.class);
		assertEquals(pojo.getTitle(), "Coder From Scratch");

	}

	@Test
	void toJson() {

		SimpleTestCasePOJO pojo = new SimpleTestCasePOJO();
		pojo.setTitle("Converting to JsonNode");
		JsonNode jsonNode = Json.toJson(pojo);
		assertEquals(jsonNode.get("title").asText(), "Converting to JsonNode");

	}

	@Test
	void stringyfy() throws JsonProcessingException {

		SimpleTestCasePOJO pojo = new SimpleTestCasePOJO();
		pojo.setTitle("Converting to String");
		JsonNode jsonNode = Json.toJson(pojo);

		System.out.println(Json.stringify(jsonNode));

	}

	@Test
	void dayTestScenarioOne() throws JsonProcessingException, IllegalArgumentException {

		JsonNode jsonNode = Json.parse(dayScenarioOne);
		DayPOJO pojo = Json.fromJson(jsonNode, DayPOJO.class);
		assertEquals(pojo.getName(), "Christmas Day");
		assertEquals(pojo.getDate().toString(), "2023-12-25");

	}

	@Test
	void authorBookScenarioOne() throws JsonMappingException, JsonProcessingException {

		JsonNode jsonNode = Json.parse(bookAuthorScenarioOne);
		AuthorPOJO authorPOJO = Json.fromJson(jsonNode, AuthorPOJO.class);

		System.out.println("Author: " + authorPOJO.getAuthorName());

		for (BookPOJO eachBook : authorPOJO.getBooks()) {
			System.out.println("Book: " + eachBook.getTitle());
			System.out.println("Is In Print? " + eachBook.isInPrint());
			System.out.println("Date: " + eachBook.getPublishDate());
		}

	}

	@Test
	void prettyPrint() throws JsonProcessingException {

		SimpleTestCasePOJO pojo = new SimpleTestCasePOJO();
		pojo.setTitle("Converting to Formatted String");
		JsonNode jsonNode = Json.toJson(pojo);

		System.out.println(Json.prettyPrint(jsonNode));

	}

}
