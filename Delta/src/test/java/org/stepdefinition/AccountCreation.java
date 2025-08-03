package org.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.AccntCreationPojo;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreation {
	WebDriver driver;
	AccntCreationPojo a;

	
	  @Given("Open cherome browser log on to the consume url") public void
	  open_cherome_browser_log_on_to_the_consume_url() {
	  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	  driver.manage().window().maximize(); driver.get("https://www.facebook.com");
	  
	  
	  
	  }
	  
	  @When("Tap on the create new account button") public void
	  tap_on_the_create_new_account_button() { a= new AccntCreationPojo(driver);
	  a.clickingOnSignUpButton();
	  
	  }
	  
	  @When("Fill all the mandatory fields on the page") public void
	  fill_all_the_mandatory_fields_on_the_page() { a.formFilling(); }
	  
	  @When("Tap on the Sign up button") public void tap_on_the_sign_up_button() throws InterruptedException {
	  a.clickSignUp(); 
	  }
	 

	@Then("Close the chrome browser")
	public void close_the_chrome_browser() {
	    driver.close();
	}

}
