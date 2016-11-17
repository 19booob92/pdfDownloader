package com.molczak.seleniumDownloader.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.molczak.seleniumDownloader.entity.SubjectNameAndUrl;

public class SeleniumUtils {

	private static WebDriver driver = null;

	public static FirefoxProfile createFFProfile() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", "/home/booob/Dokumenty/sylabus2");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		firefoxProfile.setPreference("pdfjs.disabled", true);

		return firefoxProfile;
	}

	public static void downloadFile(SubjectNameAndUrl subjectNameAndUrl) {
		String url = subjectNameAndUrl.getUrl();

		if (url != null && !url.isEmpty() && url.contains("http")) {
			FirefoxProfile ffProfile = SeleniumUtils.createFFProfile();
			driver = new FirefoxDriver(ffProfile);

			driver.get(url);

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("ReportViewer1_ctl05_ctl00_CurrentPage"),
					"1"));

			WebElement saveBtn = driver.findElement(By.id("ReportViewer1_ctl05_ctl04_ctl00_ButtonImg"));
			saveBtn.click();
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportViewer1_ctl05_ctl04_ctl00_Menu")));
			saveBtn.sendKeys(Keys.ARROW_DOWN);
			saveBtn.sendKeys(Keys.ENTER);

			driver.close();
		}
	}

}
