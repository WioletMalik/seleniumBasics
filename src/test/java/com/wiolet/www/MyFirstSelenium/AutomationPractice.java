package com.wiolet.www.MyFirstSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {

	WebDriver wd;

	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void signin() {

		WebElement signin = wd.findElement(By.cssSelector("a.login"));
		signin.click();

		WebElement email = wd.findElement(By.id("email_create"));
		email.sendKeys("pivot@gmail.com");

		WebElement createAccount = wd.findElement(By.id("SubmitCreate"));
		createAccount.click();

		WebElement gender = wd.findElement(By.id("id_gender2"));
		gender.click();

		WebElement firstName = wd.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Wiolet");

		WebElement lastName = wd.findElement(By.id("customer_lastname"));
		lastName.sendKeys("Malik");

		WebElement fillemail = wd.findElement(By.id("email"));
		fillemail.sendKeys("pivot@gmail.com");

		WebElement password = wd.findElement(By.id("passwd"));
		password.sendKeys("password");

		WebElement day = wd.findElement(By.id("days"));

		Select select = new Select(day);
		select.selectByIndex(4);

		WebElement month = wd.findElement(By.id("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(4);

		WebElement Year = wd.findElement(By.id("years"));
		Select selectYear = new Select(Year);
		selectYear.selectByIndex(4);

		WebElement first = wd.findElement(By.id("firstname"));
		first.sendKeys("Wiolet");

		WebElement last = wd.findElement(By.id("lastname"));
		last.sendKeys("Malik");

		WebElement company = wd.findElement(By.id("company"));
		company.sendKeys("Pivot");

		WebElement address = wd.findElement(By.id("address1"));
		address.sendKeys("P O Box 104");

		WebElement city = wd.findElement(By.id("city"));
		city.sendKeys("Brampton");

		WebElement state = wd.findElement(By.id("id_state"));
		Select selectState = new Select(state);
		selectState.selectByIndex(4);

		WebElement postalCode = wd.findElement(By.id("postcode"));
		postalCode.sendKeys("3456789");

		WebElement country = wd.findElement(By.id("id_country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByIndex(1);

		WebElement mobile = wd.findElement(By.id("phone_mobile"));
		mobile.sendKeys("786965489");

		WebElement alias = wd.findElement(By.id("alias"));
		alias.sendKeys("My Address");

		WebElement register = wd.findElement(By.id("submitAccount"));
		register.submit();

	}

	public void tearDown() {
		 wd.quit();
	}

}
