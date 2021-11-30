package com.wiolet.www.MyFirstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	WebDriver wd;

	@BeforeMethod
	public void openBrowse() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("https://demoqa.com/checkbox");

		wd.manage().window().maximize();
	}

	@Test
	public void clickCheckBox() {

		WebElement radioButton = wd.findElement(By.id("item-2"));

		radioButton.click();

		WebElement yes = wd.findElement(By.xpath("//label[@for='yesRadio']"));

		yes.click();

		WebElement text = wd.findElement(By.cssSelector("p.mt-3"));
		String print = text.getText();
		System.out.println(print);
	}

	public void tearDown() {

		wd.quit();
	}

}
