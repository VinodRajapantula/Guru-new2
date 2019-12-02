package com.epam.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtil {
	
	static Logger log=CreateLogger.getLoggerInstance().getLogger();
	
	public static void takeScreenshot(WebDriver driver,String testName){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png") );
		} catch (IOException e) {
			System.out.println("Unable to copy screenshot");
			log.info("Unable to copy screenshot for Test Case:" + testName);
			e.printStackTrace();
		}
	}

}
