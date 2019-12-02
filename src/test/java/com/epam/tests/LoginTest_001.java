package com.epam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.pages.LoginPage;
import com.epam.utilities.CommonUtil;

public class LoginTest_001 extends BaseClass {
	
	String userName = configReader.getProperty("userName");
	String password = configReader.getProperty("password");
	String baseUrl = configReader.getProperty("baseUrl");

	@Test(groups="sanity")
	public void loginTest() throws InterruptedException {
		log.info("loginTest - Started");
		driver.get(baseUrl);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials(userName, password);
		
		if (loginPage.verifyHomePageDisplayed()){
			Assert.assertTrue(true);
			log.info("Login Test is successful");
		}else{
			
			CommonUtil.takeScreenshot(driver,"loginTest");
			log.info("Login Test is failed");
			Assert.assertTrue(false);
		}
		
		log.info("loginTest - Ended");
	}

}
