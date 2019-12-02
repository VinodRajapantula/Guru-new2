package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.epam.drivers.DriverFactory;
import com.epam.utilities.CreateLogger;
import com.epam.utilities.ReadConfigFile;

public class BaseClass {

	WebDriver driver;

	protected ReadConfigFile configReader = ReadConfigFile.getConfigReaderInstance();
	protected Logger log = CreateLogger.getLoggerInstance().getLogger();

	

	@Parameters("browser")
	@BeforeClass
	public void initBrowser(String currentBrowserName) {

		/*
		 * if (currentBrowser.equalsIgnoreCase("chrome")){
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * }else if (currentBrowser.equalsIgnoreCase("firefox")){
		 * WebDriverManager.firefoxdriver().setup(); driver = new
		 * FirefoxDriver(); }else if (currentBrowser.equalsIgnoreCase("ie")){
		 * WebDriverManager.iedriver().setup(); driver = new
		 * InternetExplorerDriver(); }
		 */
		
		try{
			driver = DriverFactory.getInstance(currentBrowserName).getDriver();
		}catch(Exception e){
			System.out.println("Browser object is null");
			System.exit(1);
		}
		
			log.info("Browser got initiated");		
			log.info("Accessing the url");
			driver.manage().window().maximize();
			log.info("Browser maximizing");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

}
