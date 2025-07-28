package org.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.LoginPage;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks extends BaseUtilities {
	public static Scenario scenario; // Global scenario object

	WebDriver driver;

	@Before
	public void setUp(Scenario sc) {
		scenario = sc;
		// driver = BaseClass.getDriver(); // You should get WebDriver from base utility

		scenario.log("🌟 Test Started: **" + scenario.getName() + "**");
		scenario.log("🚀 Initializing browser and opening application...");
	}

	@AfterStep
	public void captureScreenshotOnFailure(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			try {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

				// Capture screenshot as bytes
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				// Attach to cucumber report
				scenario.attach(screenshot, "image/png", "❌ Step Failed - Screenshot Captured");

				// Log fancy message 😎
				scenario.log("💥 Oops! Step failed... Screenshot captured for your rescue! 🛡️");

			} catch (Exception e) {
				scenario.log("⚠️ Unable to capture screenshot due to: " + e.getMessage());
				e.printStackTrace();
				Throwable cause = e.getCause();
				System.out.println(cause);

			}
		}
	}

	@After
	public void tearDown() {
		scenario.log("✅ Test Completed: " + scenario.getName());
		scenario.log("🧹 Closing browser and cleaning up resources...");

		// BaseUtilities.quitDriver(); // Call quit or close method from your utility
	}

}
