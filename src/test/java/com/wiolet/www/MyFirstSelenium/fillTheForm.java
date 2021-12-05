package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fillTheForm {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		;
	}

	@Test
	public void contactUs() {

		WebElement contact = wd.findElement(By.cssSelector("#contact-link > a"));
		contact.click();
		WebElement subject = wd.findElement(By.id("id_contact"));
		Select select = new Select(subject);
		select.selectByIndex(1);
		WebElement email = wd.findElement(By.id("email"));
		WebElement order = wd.findElement(By.id("id_order"));
		WebElement chooseFile = wd.findElement(By.id("fileUpload"));
		WebElement message = wd.findElement(By.id("message"));
		WebElement send = wd.findElement(By.cssSelector("#submitMessage>span"));
		email.sendKeys("wiolet@gmail.com");
		order.sendKeys("abc321");
		message.sendKeys("Order update pls");
		chooseFile.sendKeys("/Users/wioletginotra/Desktop");
		send.click();
		WebElement customerServiceMessage = wd.findElement(By.cssSelector("#center_column>p"));
		String text = customerServiceMessage.getText();
		Assert.assertEquals(text, "Your message has been successfully sent to our team.");
	}

	public void tearDown() {
		wd.quit();
	}

}
