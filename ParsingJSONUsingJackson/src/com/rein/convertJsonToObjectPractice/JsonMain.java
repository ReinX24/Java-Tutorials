package com.rein.convertJsonToObjectPractice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.rein.jacksonandsimpleobjects.Json;

public class JsonMain {
	
	public static void main(String[] args) {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://jokes-by-api-ninjas.p.rapidapi.com/v1/jokes"))
				.header("X-RapidAPI-Key", "b206343f24msh070aef739f177eep14858bjsn2b7b2fe92606")
				.header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response;
		try {

			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

			String jsonString = response.body().toString();
			
			// Removing the brackets at the start and end before parsing
			jsonString = jsonString.replace("[", "");
			jsonString = jsonString.replace("]", "");
			
			System.out.println(jsonString);
			
			JsonNode jsonNode = Json.parse(jsonString);

			System.out.println(jsonNode.get("joke").asText());
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
