package com.molczak.seleniumDownloader.runners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient c = HttpClients.createDefault();

		HttpUriRequest req = RequestBuilder
				.get("http://ue.e-sylabus.pl/SL/Reportsforms/default.aspx?options=KwxAI7St3ic/bvaRdqyEeQ==").build();

		HttpResponse response = c.execute(req);
		InputStream content = response.getEntity().getContent();

		BufferedReader reader = new BufferedReader(new InputStreamReader(content));

		String line = "";

		while ((line = reader.readLine()) != null) {
			System.err.println(line);
		}

	}
}
