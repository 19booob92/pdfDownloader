package com.molczak.seleniumDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.molczak.seleniumDownloader.entity.SubjectNameAndUrl;
import com.molczak.seleniumDownloader.utils.HTTPConnector;
import com.molczak.seleniumDownloader.utils.JsonConverter;
import com.molczak.seleniumDownloader.utils.SeleniumUtils;

public class DownloadJsons {
	
	public static final String URI = "http://ue.e-sylabus.pl/ForStudents/GetPlanOfStudies";
	
	private HTTPConnector httpConnector = new  HTTPConnector();
	private JsonConverter converter = new JsonConverter();
	private WebDriver driver = new FirefoxDriver();
	
	public List<String> saveData() throws ClientProtocolException, IOException {
		
		FirefoxProfile ffProfile = SeleniumUtils.createFFProfile();
		driver = new FirefoxDriver(ffProfile);
				
		HttpResponse downloadJson = httpConnector.downloadJson();

		InputStream content = downloadJson.getEntity().getContent();

		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(content));
		
		Optional<List<SubjectNameAndUrl>> parseJsonToEntity = converter.parseJsonToEntity(bufferedInputStream);
		parseJsonToEntity.get().stream().forEach((subjectNameAndUrl) -> {
			SeleniumUtils.downloadFile(driver, subjectNameAndUrl);
		}); 
		
		return Collections.emptyList();
	}
	
	
}
