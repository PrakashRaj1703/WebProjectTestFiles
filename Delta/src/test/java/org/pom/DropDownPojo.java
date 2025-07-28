package org.pom;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class DropDownPojo {
	WebDriver driver;
	Wait<WebDriver> wait1;

	public DropDownPojo(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//a[contains(normalize-space(.),'Demo')][1]/preceding::li[@id='menu-item-313']"),
			@FindBy(xpath = "//li[@id='menu-item-313']/a[1]"),
			@FindBy(xpath = "//li[contains(@class,'menu-item menu-item-type-custom')]//a[1]") })
	private WebElement demoSelenium;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "//button[normalize-space(.)='Forms']"),
			@FindBy(xpath = "//button[normalize-space(.)='Forms']/descendant-or-self::*[2]")

	})
	private WebElement forms;

	@CacheLookup
	@FindAll({ @FindBy(xpath = "(//a[contains(@class,'block px-4')]/following-sibling::a)[2]"),
			@FindBy(xpath = "(//a[text()='Checkboxes (Multiple Selection)']/following-sibling::a)[2]") })
	private WebElement dropDown;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "(//button[contains(@class,'tab px-4')])[1]"),
			@FindBy(xpath = "//button[@data-target='simple-dropdown']") })
	private WebElement simpleDropdown;
	@CacheLookup
	@FindAll({ @FindBy(xpath = "(//select[contains(@class,'form-select block')])[1]"),
			@FindBy(xpath = "(//h3[contains(@class,'text-xl font-semibold')]/following-sibling::select)[1]")

	})

	private WebElement options;

	public WebElement getDemoSelenium() {
		return demoSelenium;
	}

	public WebElement getForms() {
		return forms;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSimpleDropdown() {
		return simpleDropdown;
	}

	public WebElement getOptions() {
		return options;
	}

	public void seleniumSelect() {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
				.withMessage("Element is not visible");

		WebElement de = demoSelenium;
		wait1.until(ExpectedConditions.elementToBeClickable(de)).click();
		//String attribute = de.getAttribute("innerText");
		// Assert.assertEquals(attribute, "ididdusd", "text is not matching");

	}

	public void formSelection() {
		WebElement fo = forms;
		wait1.until(ExpectedConditions.elementToBeClickable(fo)).click();
		String att = fo.getAttribute("textContent");
		Assert.assertTrue("Assert is not True", att.equals("Forms"));
	}

	public void dropDownoptionSelection() {
		WebElement dD = dropDown;
		wait1.until(ExpectedConditions.visibilityOf(dD)).click();
	}

	public void simpleSelection() {
		WebElement sD = simpleDropdown;
		wait1.until(ExpectedConditions.visibilityOf(sD)).click();
	}

	public void selectingOptions() {
		WebElement op = options;
		wait1.until(ExpectedConditions.visibilityOf(op)).click();
		Select s = new Select(op);
		s.selectByValue("option3");

	}

}
