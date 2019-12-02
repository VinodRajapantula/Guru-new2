package com.epam.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.CreateLogger;



public class HomePage {
	
	private WebDriver driver;
	
	Logger log=CreateLogger.getLoggerInstance().getLogger();
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement newCustomerLink;
	
	public NewCustomerPage getNewCustomerPage(){
		newCustomerLink.click();
		log.info("Clicked on New Cutomer Link");
		return new NewCustomerPage(driver);
	}
	
}
