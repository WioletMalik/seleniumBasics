package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumProject {

	// declare web driver variable of interface created
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		// using bonigarcia
		WebDriverManager.chromedriver().setup();
		// download the Webdriver manager
		// init by obj of Ref. Variable of an interface of the class implemented it
		wd = new ChromeDriver();
		// method to get the URL of the browser we intent to get
		wd.get("http://demoqa.com/login");
		// maximize the browser windows
		wd.manage().window().maximize();
	}

	@Test
	public void loginToToolaQA() {

		WebElement userName = wd.findElement(By.cssSelector("#userName"));
		WebElement passWord = wd.findElement(By.cssSelector("#password"));
		WebElement logIn = wd.findElement(By.cssSelector("#login"));

		userName.sendKeys("testuser");
		passWord.sendKeys("Password@123");

		logIn.click();

		WebElement userNameOnLoggedInPage = wd.findElement(By.cssSelector("#userName-value"));

		String getUserNameText = userNameOnLoggedInPage.getText();
	}
	
}
