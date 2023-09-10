package com.rapidapi.apicalls;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class Call {

	public static void main(String[] args) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://jokes-by-api-ninjas.p.rapidapi.com/v1/jokes"))
				.header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
				.header("X-RapidAPI-Key", "b206343f24msh070aef739f177eep14858bjsn2b7b2fe92606")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		HttpResponse<String> responseList = null;

		try {

			responseList = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(responseList.body().toString());
			
			// Cleaning up the data that we have received
			String responseStr = responseList.body().toString();			
			String jokeStr = responseStr.substring(responseStr.indexOf(" "),
					responseStr.lastIndexOf("}")).trim();
			
			System.out.println(jokeStr);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
