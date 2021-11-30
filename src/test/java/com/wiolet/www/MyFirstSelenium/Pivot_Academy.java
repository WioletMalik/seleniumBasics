package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pivot_Academy {

	WebDriver wd;

	@BeforeMethod
	public void logIn() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("https://demoqa.com/login");

		wd.manage().window().maximize();
	}

	@Test
	public void loginDetails() {

		WebElement userName = wd.findElement(By.id("userName"));
		WebElement password = wd.findElement(By.id("password"));
		userName.sendKeys("pivot_academy");
		password.sendKeys("Password@123");

		WebElement loginButton = wd.findElement(By.id("login"));
		loginButton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement userNameOnLoggedInPage = wd.findElement(By.id("userName-value"));
		String getUserNameText = userNameOnLoggedInPage.getText();
		System.out.println("User name verified:" + getUserNameText);

		WebElement logOutButton = wd.findElement(By.id("submit"));
		logOutButton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement logOutElement = wd.findElement(By.xpath("//div[@style='margin-bottom: 50px;']"));
		String logOutMessage = logOutElement.getText();
		System.out.println("Log out message:" + logOutMessage);
	}

	@AfterMethod
	public void tearDown() {

		wd.quit();
	}
}
