package com.epam.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ie extends Driver{

	@Override
	public WebDriver getDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		return driver;
	}

}
