package org.pom;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.mozilla.javascript.ast.SwitchCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPage {
	WebDriver driver;
	Scenario scenario;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[@type='text']"), @FindBy(xpath = "//div[@class='_6lux']/child::input"),
			@FindBy(id = "email") })
	private WebElement enteremail;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[contains(@class,'_9npi')]"), @FindBy(id = "pass"),
			@FindBy(xpath = "//input[@type='password']"), @FindBy(xpath = "//div[@class='_6lux']/child::div")

	})
	private WebElement enterpassword;

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//button[normalize-space(.)='Log in']"), @FindBy(id = "u_0_5_2r"),
			@FindBy(xpath = "//button[@type='submit']"), @FindBy(xpath = "//div[@class='_6ltg']/child::button") })
	private WebElement loginBtn;

	public WebElement getEnteremail() {
		return enteremail;
	}

	public WebElement getEnterpassword() {
		return enterpassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginmail(String userName) {
		// Scenario sc;
		/*
		 * Wait<WebDriver> wait = new
		 * FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
		 * .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		 * WebElement emailFiled = (WebElement) wait
		 * .until(ExpectedConditions.visibilityOf((WebElement) getEnteremail()));
		 * System.out.println(emailFiled.getText());
		 */
		String emailAttribute = getEnteremail().getAttribute("aria-label");
		String value1 = "Email ID and Password";
		String value2 = "Invalid emailID and Password";
		String value3 = "Email address or phone number";

		// Assert.assertTrue("not working da
		// maame",emailAttribute.trim().equalsIgnoreCase("rerewerrre") );
		switch (emailAttribute) {

		case "Email ID and Password":
			System.out.println("Value 1 working as expected");
			break;
		case "Invalid emailID and Password":
			System.out.println("Value 2 working as expected");
			break;
		case "Email address or phone number":
			System.out.println("Value 3 working as expected");
			break;
		default:
			System.out.println("None of above values working as expected");

			break;
		}
		// Scenario s3;
		// scenario.log(value3);
		// Reporter.log("Email field entered", true);

		/*
		 * System.out.println(emailAttribute); if
		 * (emailAttribute.equals("Email address or phone number")) {
		 * System.out.println("pass");
		 * 
		 * } else { System.out.println("fail"); }
		 */
		getEnteremail().sendKeys(userName);
	}

	public void loginPassword(String password) {
		getEnterpassword().sendKeys(password);
	}

	public void clickLoginButton() {
		getLoginBtn().click();
	}

}
