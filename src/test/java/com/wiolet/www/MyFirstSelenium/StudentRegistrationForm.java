package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentRegistrationForm {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/automation-practice-form");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void fillForm() {

		WebElement firstName = wd.findElement(By.id("firstName"));
		WebElement lastName = wd.findElement(By.id("lastName"));
		WebElement email = wd.findElement(By.id("userEmail"));
		WebElement secondRadioButton = wd.findElement(By.cssSelector("label[for='gender-radio-2']"));
		WebElement mobileNumber = wd.findElement(By.id("userNumber"));

		firstName.sendKeys("wiolet");
		lastName.sendKeys("Malik");
		email.sendKeys("wiolet@gmail.com");
		secondRadioButton.click();
		mobileNumber.sendKeys("5647834678");

		WebElement datePicker = wd.findElement(By.id("dateOfBirthInput"));
		datePicker.click();

		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.react-datepicker-popper")));

		WebElement currentMonth = wd.findElement(By.cssSelector("div.react-datepicker__current-month"));
		WebElement nextMonthsButton = wd.findElement(By.cssSelector("button[aria-label='Next Month']"));

		while (!currentMonth.getText().equals("October 2022"))

		{
			nextMonthsButton.click();
		}

		WebElement selectDate = wd.findElement(By.cssSelector("div[aria-label='Choose Saturday, October 1st, 2022']"));

		selectDate.click();

		WebElement subject = wd.findElement(By.id("subjectsInput"));
		subject.sendKeys("Maths");

		subject.sendKeys(Keys.ENTER);

		WebElement checkBoxOne = wd.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));

		checkBoxOne.click();

		JavascriptExecutor jse = (JavascriptExecutor) wd;
		jse.executeScript("window.scrollBy(0,500)");

		WebElement picture = wd.findElement(By.id("uploadPicture"));
		picture.sendKeys("/Users/wioletginotra/Desktop");

		WebElement address = wd.findElement(By.id("currentAddress"));
		address.sendKeys("Brampton");

		WebElement state = wd.findElement(By.id("react-select-3-input"));
		state.sendKeys("NCR");
		state.sendKeys(Keys.ENTER);

		WebElement city = wd.findElement(By.id("react-select-4-input"));
		city.sendKeys("Delhi");
		city.sendKeys(Keys.ENTER);

		WebElement submit = wd.findElement(By.id("submit"));
		submit.submit();

	}

	@AfterMethod
	public void tearDown() {

		wd.quit();

	}
}
