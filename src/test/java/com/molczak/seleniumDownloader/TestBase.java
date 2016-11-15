package com.molczak.seleniumDownloader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static final String BASE_URL = "http://ue.e-sylabus.pl/Home/Login";

	protected WebDriver firefoxDriver;
	protected WebDriverWait wait;

	protected TestBase() {
		System.setProperty("webdriver.gecko.driver", "geckodriver");

		firefoxDriver = new FirefoxDriver();
		wait = new WebDriverWait(firefoxDriver, 15);
	}
}
