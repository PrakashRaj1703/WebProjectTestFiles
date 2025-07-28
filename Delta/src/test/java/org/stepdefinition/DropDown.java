package org.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.DropDownPojo;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	WebDriver driver;
	DropDownPojo d = new DropDownPojo(driver);

	@Given("Log on to the Browser and launch url")
	public void log_on_to_the_browser_and_launch_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationcentral.com/");
	}

	@When("select the page and do actions")
	public void select_the_page_and_do_actions() {
		d.seleniumSelect();
	}

	@When("select dropDOwn and do actions")
	public void select_drop_d_own_and_do_actions() {
		d.formSelection();
	}

	@When("do some actions on the page")
	public void do_some_actions_on_the_page() {
		d.dropDownoptionSelection();
	}

	@Then("close the current tab and quite the browser")
	public void close_the_current_tab_and_quite_the_browser() {
		d.simpleSelection();
		d.selectingOptions();
	}

}
