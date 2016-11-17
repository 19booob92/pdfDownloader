package com.molczak.seleniumDownloader.runners;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.molczak.seleniumDownloader.DownloadJsons;

public class Runner {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		DownloadJsons downloadJsons = new DownloadJsons();
		
		try {
			downloadJsons.saveData();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
