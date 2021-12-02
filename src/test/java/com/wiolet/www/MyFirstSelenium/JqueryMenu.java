package com.wiolet.www.MyFirstSelenium;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryMenu {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://jqueryui.com/menu/");
		wd.switchTo().frame(0);
	}

	@Test
	public void electronic() {

		Actions action = new Actions(wd);
		WebElement electronic = wd.findElement(By.id("ui-id-4"));
		action.moveToElement(electronic).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String attributeValue = electronic.getAttribute("class");
			Assert.assertEquals(attributeValue, "ui-menu-item-wrapper ui-state-active");
		}
	}

	@Test
	public void music() {
		Actions action = new Actions(wd);
		WebElement music = wd.findElement(By.id("ui-id-9"));
		action.moveToElement(music).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String attributeValue = music.getAttribute("class");
			Assert.assertEquals(attributeValue, "ui-menu-item-wrapper");
		}
	}

	public void tearDown() {

		wd.quit();
	}

}
