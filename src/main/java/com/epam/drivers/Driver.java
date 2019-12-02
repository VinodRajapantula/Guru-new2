package com.epam.drivers;

import org.openqa.selenium.WebDriver;

public abstract class Driver {
	
	WebDriver driver;
	public abstract WebDriver getDriver();

}
