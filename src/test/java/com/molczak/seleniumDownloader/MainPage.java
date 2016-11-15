package com.molczak.seleniumDownloader;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends TestBase {

	private final static String DEPARTMENT_COMBO_VAL = "FieldsOfStudySelectorVM.SelectedDepartment";
	private final static String FIELD_OF_STUDY_COMBO_VAL = "FieldsOfStudySelectorVM.SelectedFieldOfStudy";

	public MainPage() {
		super();
	}

	@Test
	public void openMainPage() {
		firefoxDriver.get(BASE_URL);
		
		firefoxDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement login = firefoxDriver.findElement(By.className("alinkLogin"));
		login.click();
		
		firefoxDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement departmentCombo = firefoxDriver.findElement(By.xpath("[value='" + DEPARTMENT_COMBO_VAL + "']"));

		wait.until(ExpectedConditions.textToBePresentInElementValue(departmentCombo, "Ekonomii, Zarządzania i Turystyki"));
		
		departmentCombo.sendKeys(Keys.ARROW_DOWN);
		departmentCombo.sendKeys(Keys.ARROW_DOWN);
		departmentCombo.sendKeys(Keys.ARROW_DOWN);
		departmentCombo.sendKeys(Keys.ENTER);

		WebElement fieldOfStudyCombo = firefoxDriver
				.findElement(By.xpath("[value='" + FIELD_OF_STUDY_COMBO_VAL + "']"));

		Assert.assertEquals(fieldOfStudyCombo.getText(), "Analityka gospodarcza");
	}

}
