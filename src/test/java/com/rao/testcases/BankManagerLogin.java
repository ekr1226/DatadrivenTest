package com.rao.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rao.BaseClass.BaseClass;

public class BankManagerLogin extends BaseClass {
	
@Test
	public void loginAsManager() throws InterruptedException
	{
	log.debug("Entered into method");
		driver.findElement(By.cssSelector(OR.getProperty("buttonManager"))).click();
	
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomer"))),"Element  Not present");
		//driver.findElement(By.cssSelector(OR.getProperty("addCustomer"))).click();
	}
}
