package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsFirstClass {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://www.globalsqa.com/demo-site/tooltip/");
		wd.manage().window().maximize();

	}

	@Test
	public void toolTip() {

		String expectedText = "ui-id-53";
		Actions action = new Actions(wd);
		WebElement toolTip = wd.findElement(By.xpath("//div[@class='ui-widget-header ui-corner-all'])"));
		action.moveToElement(toolTip).perform();
		String toolTipText = toolTip.getText();

		Assert.assertEquals(toolTipText, expectedText);
	}

}