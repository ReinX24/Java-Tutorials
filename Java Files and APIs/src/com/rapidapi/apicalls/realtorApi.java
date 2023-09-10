package com.rapidapi.apicalls;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class realtorApi {

	public static void main(String[] args) {

		HttpRequest apiRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://realtor.p.rapidapi.com/locations/v2/auto-complete?input=new%20york&limit=1"))
				.header("X-RapidAPI-Key", "b206343f24msh070aef739f177eep14858bjsn2b7b2fe92606")
				.header("X-RapidAPI-Host", "realtor.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		HttpResponse<String> apiResponse = null;

		try {
			apiResponse = HttpClient.newHttpClient().send(apiRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println(apiResponse.body().toString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
