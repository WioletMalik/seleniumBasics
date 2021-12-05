package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRM {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		wd.manage().window().maximize();
	}

	@Test
	public void login() {

		Actions action = new Actions(wd);
		
		WebElement userName = wd.findElement(By.id("txtUsername"));
		WebElement password = wd.findElement(By.id("txtPassword"));
		WebElement loginButton = wd.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.submit();
		
		WebElement userProfile = wd.findElement(By.xpath("//a[@id='welcome']"));
		userProfile.click();
		WebElement logOut = wd.findElement(By.cssSelector("ul>li:nth-child(3)>a"));
		//action.moveToElement(logOut).perform();
		logOut.click();

	}
	
	public void tearDown() {
		wd.quit();
	}
}
