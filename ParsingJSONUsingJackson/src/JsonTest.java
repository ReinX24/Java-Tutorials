import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

class JsonTest {

	private String testCaseOne = "{ \"title\": \"Coder From Scratch\"}";

	@Test
	void testParse() throws IOException {
		
		JsonNode nodeOne = Json.parse(testCaseOne);
		assertEquals(nodeOne.get("title").asText(), "Coder From Scratch");
	}
	
	@Test
	void fromJson() throws IOException {
		
		JsonNode nodeOne = Json.parse(testCaseOne);
		JsonInfo jsonInfo =  Json.fromJson(nodeOne, JsonInfo.class);
		assertEquals(jsonInfo.getTitle(), "Coder From Scratch");
			
	}

}
