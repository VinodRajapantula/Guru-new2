package com.epam.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.CreateLogger;


public class NewCustomerPage {

	private WebDriver driver;
	Logger log=CreateLogger.getLoggerInstance().getLogger();
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	private WebElement customerNameTextbox;

	@CacheLookup
	@FindBy(css = "input[name='rad1'][value='m']")
	private WebElement maleRadioButton;

	@CacheLookup
	@FindBy(css = "input[name='rad1'][value='f']")
	private WebElement femaleRadioButton;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	private WebElement dateOfBirthText;

	@CacheLookup
	@FindBy(css = "textarea[name='addr']")
	private WebElement addressText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	private WebElement cityText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	private WebElement stateText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	private WebElement pinText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	private WebElement mobileText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	private WebElement emailText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordText;

	@CacheLookup
	@FindBy(css = "input[value='Submit']")
	private WebElement submitButton;

	public void enterCustomerName(String cusromerName) {
		log.info("Inside NewCustomer Page cusromerName:" + cusromerName);
		customerNameTextbox.sendKeys(cusromerName);
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleRadioButton.click();
			log.info("Clicked on male radio button");
		} else {
			femaleRadioButton.click();
			log.info("Clicked on female radio button");
		}
	}

	public void enterdateOfBirth(String month, String date, String year) {
		dateOfBirthText.sendKeys(month);
		dateOfBirthText.sendKeys(date);
		dateOfBirthText.sendKeys(year);
	}

	public void enterAddress(String address) {
		addressText.sendKeys(address);
		log.info("Entered Address");
	}

	public void enterCity(String city) {
		cityText.sendKeys(city);
		log.info("Entered city");
	}

	public void enterState(String state) {
		stateText.sendKeys(state);
		log.info("Entered state");
	}

	public void enterPin(String pin) {
		pinText.sendKeys(pin);
		log.info("Entered pin");
	}

	public void enterMobile(String mobile) {
		mobileText.sendKeys(mobile);
		log.info("Entered mobile");

	}

	public void enterEmail(String email) {
		emailText.sendKeys(email);
		log.info("Entered Email");
	}

	public void enterPassword(String password) {
		passwordText.sendKeys(password);
		log.info("Entered password");
	}

	public void clickOnSubmitButton() {
		submitButton.click();
		log.info("Clicked on submitt button");
	}

	public boolean isNewCustomerRegisted() {
		if (isAlertPresent()){
			acceptAlert();
			return false;
		}else{
			return driver.getPageSource().contains("Customer Registered Successfully!!!");
		}
	}

	

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
