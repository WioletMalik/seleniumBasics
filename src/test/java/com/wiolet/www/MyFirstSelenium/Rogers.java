package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rogers {

	WebDriver wd;

	@BeforeMethod
	public void rogers() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("https://www.rogers.com/");

		wd.manage().window().maximize();
	}

	@Test
	public void logo() {

		WebElement logoDisplay = wd.findElement(By.xpath("//img[@class='rcl-icon-logo' and @alt='Rogers']"));
		boolean result= logoDisplay.isDisplayed();
		System.out.println(result);

	}

	@AfterMethod
	public void tearDown() {

		wd.quit();
	}
}
