package org.stepdefinition;

import java.time.Duration;
import java.time.Instant;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.LoginPage;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login {
	WebDriver driver;
	WebDriverWait wait;
	LoginPage l;
	Instant start;
	long startTime;

	@Given("Open browser and launch URL")
	public void open_browser_and_launch_url() {
		start = Instant.now();
		startTime = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		l = new LoginPage(driver);
	}

	@When("Pass email on the email field {string}")
	public void pass_email_on_the_email_field(String email1) {
		l.loginmail(email1);

	}

	@When("pass password on the password field {string}")
	public void pass_password_on_the_password_field(String password1) {
		l.loginPassword(password1);
	}

	@When("Click on the signIn button")
	public void click_on_the_sign_in_button() {
		l.clickLoginButton();
	}

	@When("Validate the displaying notifications")
	public void validate_the_displaying_notifications() {
		long endTime = System.currentTimeMillis();
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.err.println("Test case execution timing :" + between + "ms");
		System.err.println("Test case execution timing :" + (startTime - endTime) / 1000 + "seconds");
		// System.out.println("Test case execution timing :"+(totalTime)/1000);

		driver.close();
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.close();

	}

	@Given("Open browser and launching the URL")
	public void openBrowserAndLaunchingTheURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationcentral.com");
	}

	@When("Check if the first dropdown working as expected")
	public void checkIfTheFirstDropdownWorkingAsExpected() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[starts-with(normalize-space(.),'Demo – Selenium Pract')]")))
				.click();

	}

	@When("Check if the second dropdown working as expected")
	public void checkIfTheSecondDropdownWorkingAsExpected() {

	}

	@When("Check if the third dropdown working as expected")
	public void checkIfTheThirdDropdownWorkingAsExpected() {
	}

	@Then("close the browser")
	public void closeTheBrowser() {
		driver.close();

	}

}
