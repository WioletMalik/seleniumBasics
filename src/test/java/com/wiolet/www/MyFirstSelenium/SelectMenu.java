package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMenu {
	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://jqueryui.com/selectmenu/");
		wd.switchTo().frame(0);
	}

	@Test
	public void select() {

		WebElement speed = wd.findElement(By.id("speed"));

		Select select = new Select(speed);
		select.selectByIndex(4);
		
		WebElement file = wd.findElement(By.id("files-button"));
		WebElement numberSeven = wd.findElement(By.id("number-button"));
		WebElement title = wd.findElement(By.id("salutation-button"));
		
		
		Select files = new Select(file);
		files.selectByValue("ui.query.js");
		Select number = new Select(numberSeven);
		number.selectByIndex(7);
		Select titleFor = new Select(title);
		titleFor.selectByIndex(2);
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
