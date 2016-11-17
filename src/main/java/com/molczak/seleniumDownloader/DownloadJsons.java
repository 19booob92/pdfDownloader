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

import com.molczak.seleniumDownloader.entity.SubjectNameAndUrl;
import com.molczak.seleniumDownloader.utils.FileUtils;
import com.molczak.seleniumDownloader.utils.HTTPConnector;
import com.molczak.seleniumDownloader.utils.JsonConverter;
import com.molczak.seleniumDownloader.utils.SeleniumUtils;

public class DownloadJsons {
	
	public static final String URI = "http://ue.e-sylabus.pl/ForStudents/GetPlanOfStudies";
	
	private HTTPConnector httpConnector = new  HTTPConnector();
	private JsonConverter converter = new JsonConverter();
	private FileUtils fileUtils = new FileUtils();
	
	public List<String> saveData() throws ClientProtocolException, IOException {
		
		HttpResponse downloadJson = httpConnector.downloadJson();

		InputStream content = downloadJson.getEntity().getContent();

		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(content));
		
		Optional<List<SubjectNameAndUrl>> parseJsonToEntity = converter.parseJsonToEntity(bufferedInputStream);
		
		parseJsonToEntity.get().stream().forEach((subjectNameAndUrl) -> {
			SeleniumUtils.downloadFile(subjectNameAndUrl);
			
			try {
				Thread.sleep(15000);
				
				fileUtils.changeLastFileName(subjectNameAndUrl.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}); 
		
		return Collections.emptyList();
	}
	
	
}
