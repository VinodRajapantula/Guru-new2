package com.epam.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.CreateLogger;


public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Logger log=CreateLogger.getLoggerInstance().getLogger();
	
	@FindBy(css="input[name='uid']")
	private WebElement userName;
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="input[name='btnLogin']")
	private WebElement loginButton;
	
	public HomePage enterLoginCredentials(String uName, String pwd){
		userName.sendKeys(uName);
		log.info("User name entered as: "+ uName);
		password.sendKeys(pwd);
		log.info("Password entered");
		loginButton.click();
		log.info("Clicked on submit button");
		Point point  = password.getLocation();
		point.getX();
		point.getY();
		return new HomePage(driver);
	}
	
	public boolean verifyHomePageDisplayed(){
			try{acceptAlert();
			}catch(NoAlertPresentException e){
				return true;
			}
			
			return driver.getTitle().equals("Guru99 Bank Manager HomePage");
	}
	
	
	private void acceptAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	
	
	
	

}
