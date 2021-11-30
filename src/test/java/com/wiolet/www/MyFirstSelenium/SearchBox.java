package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBox {

	WebDriver wd;

	@BeforeMethod
	public void searchBox() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("http://automationpractice.com/index.php");

		wd.manage().window().maximize();
	}

	@Test
	public void dress() {

		WebElement dress = wd.findElement(By.id("search_query_top"));
		dress.sendKeys("‘Dress");
		dress.clear();
		dress.sendKeys("Top");
		WebElement search = wd.findElement(By.xpath("//button[@name='submit_search']"));
		search.click();

	}

	@AfterMethod
	public void tearDown() {

		wd.quit();
	}
}
