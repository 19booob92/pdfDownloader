package com.molczak.seleniumDownloader.utils;

import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

import com.molczak.seleniumDownloader.DownloadJsons;
import com.molczak.seleniumDownloader.entity.RequestContentBuilder;

public class HTTPConnector {

	private RequestContentBuilder requestContent = new RequestContentBuilder();

	public HttpResponse downloadJson() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.createDefault();

		HttpUriRequest httpRequest = RequestBuilder.post(DownloadJsons.URI)
				.addHeader(HttpHeaders.ACCEPT, "application/json").addHeader(HttpHeaders.ACCEPT, "text/javascript")
				.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
				.addHeader(HttpHeaders.HOST, "ue.e-sylabus.pl")
				.addHeader(HttpHeaders.REFERER, "http://ue.e-sylabus.pl/ForStudents")
				.setEntity(requestContent.prepareEntity()).build();

		return httpClient.execute(httpRequest);
	}

	// private CookieStore createCookieStore() {
	// CookieStore cookieStore = new BasicCookieStore();
	// BasicClientCookie cookie = new BasicClientCookie(
	// "__RequestVerificationToken=A_4LDXtKjEZEXYa78lyYEyKsoCUjlWYr-9jvwx2uUl9FwYAO_i8U-lOx_vEWacf8r4gFkbiaQ61njzgg6-JkaoHXBxBaYgIpJJ8tnrSv7NutrAUB8SeClPhmNKOeDFPIeR_fi11DMZ_4QDude9Q8bQ2",
	// "A_4LDXtKjEZEXYa78lyYEyKsoCUjlWYr-9jvwx2uUl9FwYAO_i8U-lOx_vEWacf8r4gFkbiaQ61njzgg6-JkaoHXBxBaYgIpJJ8tnrSv7NutrAUB8SeClPhmNKOeDFPIeR_fi11DMZ_4QDude9Q8bQ2");
	// cookie.setDomain("ue.e-sylabus.pl");
	//
	// cookieStore.addCookie(cookie);
	//
	// return cookieStore;
	// }

}
