package com.molczak.seleniumDownloader.entity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class RequestContentBuilder {

	public UrlEncodedFormEntity prepareEntity() throws UnsupportedEncodingException {

		List<NameValuePair> nameValuePair = new ArrayList<>();

		nameValuePair.add(new BasicNameValuePair("fieldOfStudy", "8o45llLhCrEnWRPe9HtKkw=="));
		nameValuePair.add(new BasicNameValuePair("levelOfStudies", "1"));
		nameValuePair.add(new BasicNameValuePair("speciality", "0"));
		nameValuePair.add(new BasicNameValuePair("specjalization", "0"));
		nameValuePair.add(new BasicNameValuePair("user", "0"));
		nameValuePair.add(new BasicNameValuePair("year", "u2r1Xfd7V5qE5Ii603ao8w=="));

		return new UrlEncodedFormEntity(nameValuePair, "UTF-8");
	}
}
