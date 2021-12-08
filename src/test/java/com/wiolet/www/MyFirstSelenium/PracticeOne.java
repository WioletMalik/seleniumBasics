package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeOne {

	// Create ref variable of the webdriver interface
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		// Tell chrome which chrome driver it needs to use
		// using webDriver Manager
		WebDriverManager.chromedriver().setup();

		// Intilised it with chrome driver object class

		wd = new ChromeDriver();

		// Get the URL of the website that we intend to test

		wd.get("https://demoqa.com/checkbox");

		// Maximise the browser

		wd.manage().window().maximize();

	}

	@Test
	public void sendKeys() {

		WebElement name = wd.findElement(By.id("userName"));
		name.sendKeys("Wiolet");

		WebElement email = wd.findElement(By.id("userEmail"));
		email.sendKeys("abc@gmail.com");

		WebElement currentAddress = wd.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Canada");

		WebElement permanentAddress = wd.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys("India");

		WebElement submit = wd.findElement(By.id("submit"));
		submit.click();

	}

	@Test
	public void clickCheckBox() {

		WebElement CheckBox = wd.findElement(By.cssSelector("span.rct-title"));
		CheckBox.click();
		WebElement text = wd.findElement(By.id("result"));
		String message = text.getText();
		System.out.println(message);

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();

	}
}
