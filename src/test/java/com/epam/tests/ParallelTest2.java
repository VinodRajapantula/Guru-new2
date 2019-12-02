package com.epam.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ParallelTest2 extends BaseClass{
	
	@Test
	public void test2(){
		log.info("Running ParallelTest2 ");
		driver.get("http://google.com");
		log.info("access google page in  ParallelTest2 ");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("select");
		log.info("Entered Hello in ParallelTest2 ");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		log.info("Press enter in ParallelTest2 ");
		
		
	}

}
