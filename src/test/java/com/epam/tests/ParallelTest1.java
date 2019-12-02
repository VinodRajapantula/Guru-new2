package com.epam.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ParallelTest1 extends BaseClass{
	
	@Test
	public void test1(){
		log.info("Running ParallelTest1 ");
		driver.get("http://google.com");
		log.info("Access google page ParallelTest1 ");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		log.info("Entered Hello in ParallelTest1 ");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		log.info("Press enter in ParallelTest1 ");
		
	}

}
