package com.wiolet.www.MyFirstSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandles {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		wd.manage().window().maximize();
	}

	@Test
	public void switchBrowsers() {

		WebElement userName = wd.findElement(By.id("txtUsername"));
		WebElement password = wd.findElement(By.id("txtPassword"));
		WebElement loginButton = wd.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.submit();

		String mainWindowHandle = wd.getWindowHandle();
		System.out.println("Main window handle is :" + mainWindowHandle);

		WebElement nextWindow = wd.findElement(By.cssSelector("a.help-icon-div"));
		nextWindow.click();

		Set<String> s1 = wd.getWindowHandles();
		for (String newWindow : s1) {
			if (!mainWindowHandle.equals(newWindow))
				;
			{
				wd.switchTo().window(newWindow);
			}
		}

		WebElement adminUser = wd.findElement(By.cssSelector("li:nth-child(1) > a > span.blocks-item-title"));
		String Text = adminUser.getText();
		System.out.println("Text on userAdmin:" + Text);

		wd.switchTo().window(mainWindowHandle);

	}

	public void tearDown() {
		// wd.quit();
	}
}
