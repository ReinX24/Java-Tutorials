

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	
	private static ObjectMapper objectMapper = getDefaultObjectMapper();

	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		return defaultObjectMapper;
	}
	
	static JsonNode parse(String src) throws IOException {
		return objectMapper.readTree(src);
	}
	
	public static <A> A fromJson(JsonNode node, Class<A> paraClass) throws JsonProcessingException {
		return objectMapper.treeToValue(node, paraClass);
	}

}
