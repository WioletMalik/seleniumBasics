package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleOnPage {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("http://automationpractice.com/index.php");

		wd.manage().window().maximize();
	}

	@Test
	public void pageTitle() {

		String pageTitle = wd.getTitle();

		System.out.println(pageTitle);
	}

}
