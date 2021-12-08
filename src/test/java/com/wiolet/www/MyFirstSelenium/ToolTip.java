package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://jqueryui.com/tooltip/");
		wd.switchTo().frame(0);
	}

	@Test
	public void toopTip() {
		Actions action = new Actions(wd);
		WebElement toolTip = wd.findElement(By.cssSelector("body>p:nth-child(1)>a"));
		action.moveToElement(toolTip).perform();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String toolTipText = toolTip.getAttribute("aria-describedby");
		Assert.assertTrue(toolTipText.contains("ui-id"));

		WebElement secondToolTip = wd.findElement(By.cssSelector("body>p:nth-child(2)>a"));
		action.moveToElement(secondToolTip).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String secondToolTipText = secondToolTip.getAttribute("aria-describedby");
		Assert.assertTrue(secondToolTipText.contains("ui-id"));

		WebElement thirdToolTip = wd.findElement(By.cssSelector("#age"));
		action.moveToElement(thirdToolTip).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String thirdToolTipText = thirdToolTip.getAttribute("aria-describedby");
		Assert.assertTrue(thirdToolTipText.contains("ui-id"));

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
