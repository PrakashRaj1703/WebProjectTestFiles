package org.pom;

import java.time.Duration;

import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccntCreationPojo {
	WebDriver driver;
	WebDriverWait wait;

	public AccntCreationPojo(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	public WebElement getTappingCreateNewButto() {
		return tappingCreateNewButto;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDayDropdown() {
		return dayDropdown;
	}

	public WebElement getMonthDropdown() {
		return monthDropdown;
	}

	public WebElement getYearDropdown() {
		return yearDropdown;
	}

	public WebElement getGenderSelector() {
		return genderSelector;
	}

	public WebElement getEmailBox() {
		return emailBox;
	}

	public WebElement getPasswordCreationBox() {
		return passwordCreationBox;
	}

	public WebElement getClickSigninButton() {
		return clickSigninButton;
	}

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//div[@class='_6ltg']/child::a"), @FindBy(xpath = "//div[@class='_6ltg']//a[1]"),
			@FindBy(xpath = "//a[.='Create new account']") })

	private WebElement tappingCreateNewButto;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[@name='firstname']"),
			@FindBy(xpath = "//input[@data-type='text' and @id='u_0_8_v+']"),
			@FindBy(xpath = "//div[@class='placeholder']/following-sibling::input[@name='firstname']"), })
	private WebElement firstName;

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[@aria-label='Surname']"),
			@FindBy(xpath = "//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']/child::input[@name='lastname']"),
			@FindBy(css = "input[name='lastname']"), @FindBy(css = "#u_0_a_4K") })
	private WebElement lastName;

	@CacheLookup
	@FindAll({ @FindBy(css = "#day"), @FindBy(css = "select#day"),
			@FindBy(xpath = "//option[@value='1']/ancestor::select[@name='birthday_day']") })

	private WebElement dayDropdown;

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//option[@value='12']/ancestor::select[@aria-label='Month']"),
			@FindBy(css = "select[title^='Mon']"), @FindBy(css = "select[name*='month']"),
			@FindBy(css = "select[name$='month']") })
	private WebElement monthDropdown;

	@CacheLookup
	@FindAll({ @FindBy(css = "select[aria-label*='ear']"), @FindBy(css = "select[name$='year']")

	})
	private WebElement yearDropdown;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "//label[.='Male']"), @FindBy(xpath="(//label[@class='_58mt'])[2]") })
	private WebElement genderSelector;
	@CacheLookup
	@FindAll({ @FindBy(css = "input[name$='email__']"), @FindBy(css = "input#u_0_h_Sr") })

	private WebElement emailBox;
	@CacheLookup
	@FindAll({ @FindBy(css = "input[type='password']"), @FindBy(css = "input[id^='password']")

	})
	private WebElement passwordCreationBox;
	@CacheLookup
	@FindAll({ @FindBy(css = "button#u_0_n_Xo"), @FindBy(css = "button[name='websubmit']") })
	private WebElement clickSigninButton;

	public void clickingOnSignUpButton() {
		WebElement tap = getTappingCreateNewButto();
		Point buttonLocation = tap.getLocation();
		int x = buttonLocation.getX();
		int y = buttonLocation.getY();
		System.out.println("X value is :" + x + "Y value is : " + y);
		int expectedWidth = 193;
		int expectedHeight = 48;
		Dimension size = tap.getSize();
		int actualWidth = size.getWidth();
		int actualHeight = size.getHeight();
		if (expectedWidth == actualWidth && expectedHeight == actualHeight) {
			System.out.println("Button height and width are expected");

		} else {
			System.out.println("Expected button size :"+ "Expected Width"+expectedWidth+"\n"+"Expected Height"+ expectedHeight);
			System.out.println("Check Button size");
			System.out.println("Actual button size :"+ "Actual Width"+actualWidth+"\n"+"Actual Height"+ actualHeight);

		}
		System.err.println(actualWidth);
		System.err.println(actualHeight);

		String expectedBackgroundclr = "rgba(66, 183, 42, 1)";// 66, 183, 42
		String actualBackgroundclr = tap.getCssValue("background-color");
		if (actualBackgroundclr.equals(expectedBackgroundclr)) {
			System.out.println("Background colour is expected");
		} else {
			System.out.println("Actual Colour"+actualBackgroundclr);
			System.err.println("Check background colour");
		}

		wait.until(ExpectedConditions.elementToBeClickable(tap)).click();
	}

	public void formFilling() {
		WebElement firstName = getFirstName();
		wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys("Prakash");
		WebElement lastName = getLastName();
		wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Rajendran");
		WebElement daydd = wait.until(ExpectedConditions.visibilityOf(getDayDropdown()));
		Select s1 = new Select(daydd);
		s1.selectByValue("3");
		WebElement monthmm = wait.until(ExpectedConditions.visibilityOf(getMonthDropdown()));
		Select s2 = new Select(monthmm);
		s2.selectByVisibleText("Mar");
		WebElement yeardd = wait.until(ExpectedConditions.visibilityOf(getYearDropdown()));
		Select s3 = new Select(yeardd);
		s3.selectByVisibleText("1994");
		wait.until(ExpectedConditions.elementToBeClickable(getGenderSelector())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getEmailBox())).sendKeys("TestAccount@mailinator.com");
		wait.until(ExpectedConditions.elementToBeClickable(getPasswordCreationBox())).sendKeys("123123123A");
		
	}
	public void clickSignUp() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(getClickSigninButton()));
	js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth', block:'center'})", signUpButton);
	Thread.sleep(5000);
	signUpButton.click();
	}

}
