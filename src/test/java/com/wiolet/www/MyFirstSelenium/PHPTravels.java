package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PHPTravels {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://www.phptravels.net/signup");
		wd.manage().window().maximize();
	}

	@Test
	public void signUp() {
		WebElement firstName = wd.findElement(By.xpath("//input[@name='first_name']"));
		WebElement lastName = wd.findElement(By.xpath("//input[@name='last_name']"));
		WebElement phoneNum = wd.findElement(By.xpath("//input[@name='phone']"));
		WebElement email = wd.findElement(By.xpath("//input[@name='email']"));
		WebElement password = wd.findElement(By.xpath("//input[@name='password']"));
		WebElement dropDown = wd.findElement(By.id("account_type"));
		WebElement signUpButton = wd.findElement(By.cssSelector("button[type='submit']"));
		WebElement Cookies = wd.findElement(By.id("cookie_stop"));

		Select select = new Select(dropDown);

		Cookies.click();
		firstName.sendKeys("Wiolet");
		lastName.sendKeys("Malik");
		phoneNum.sendKeys("5462125902");
		email.sendKeys("wiolet@gmail.com");
		password.sendKeys("malik@123");
		select.selectByIndex(0);
		signUpButton.submit();

		WebElement loginEmail = wd.findElement(By.xpath("//input[@class='form-control' and @placeholder='Email']"));
		WebElement logoinPassword = wd.findElement(By.xpath("//input[@type='password' and @placeholder='Password']"));
		WebElement login = wd.findElement(By.cssSelector("button[type='submit']"));

		loginEmail.sendKeys("wiolet@gmail.com");
		logoinPassword.sendKeys("malik@123");
		login.click();

		WebElement loginMessage = wd.findElement(By.cssSelector("h2.sec__title.font-size-30.text-white"));
		String loginText = loginMessage.getText();
		System.out.println("Login Message is :" + loginText);

	}
	@AfterMethod
	public void tearDown() {

		wd.quit();
	}
}
