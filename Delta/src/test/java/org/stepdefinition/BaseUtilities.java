package org.stepdefinition;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseUtilities {
	
	 
	 
	    public static WebDriver driver;
	 
	    // ✅ Launch browser
	    public static void launchBrowser() {
	        WebDriverManager.chromedriver().setup();  // Chrome browser
	        driver = new ChromeDriver();
	 
	        driver.manage().window().maximize();

}}
