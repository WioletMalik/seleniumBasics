package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckRadioButton {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://jqueryui.com/checkboxradio/");
		wd.switchTo().frame(0);
	}

	@Test
	public void paris() {

		WebElement radioButton2 = wd.findElement(By.cssSelector("label[for='radio-2']"));
		WebElement checkbox2 = wd.findElement(By.cssSelector("label[for='checkbox-2']"));
		WebElement checkbox3 = wd.findElement(By.cssSelector("label[for='checkbox-2']"));

		radioButton2.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		checkbox2.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkbox3.click();

		}
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
