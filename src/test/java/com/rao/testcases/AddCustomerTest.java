package com.rao.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rao.BaseClass.BaseClass;
import com.rao.utilities.ReadExcel;

public class AddCustomerTest extends BaseClass {

	
public static ReadExcel excel = null;

public static WebDriverWait wait;

	@Test(dataProvider="getData")
	public void testData(Hashtable<String,String> data) throws InterruptedException{
		
	
		System.out.println(data.get("FirstName")+"---"+data.get("LastName")+"---"+data.get("PostalCode"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(OR.getProperty("buttonManager"))).click();
		driver.findElement(By.xpath(OR.getProperty("addCustomer"))).click();
		 Thread.sleep(2000);
		  driver.findElement(By.cssSelector(OR.getProperty("FirstName"))).sendKeys(data.get("FirstName"));;
		  driver.findElement(By.cssSelector(OR.getProperty("LastName"))).sendKeys(data.get("LastName"));
		  System.out.println(isElementPresent(By.cssSelector(OR.getProperty("PostalCode"))));
		  
		  driver.findElement(By.cssSelector(OR.getProperty("PostalCode"))).sendKeys(data.get("PostalCode"));
		  Thread.sleep(5000); 
		 driver.findElement(By.cssSelector(OR.getProperty("Submitbutton"))).click();
		 
		 //driver.switchTo().alert().accept();
		  
			/*
			 * Thread.sleep(2000); Alert alert =
			 * wait.until(ExpectedConditions.alertIsPresent()); System.out.println(alert);
			 * Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
			 * alert.accept();
			 * 
			 * Thread.sleep(2000);
			 */    
		
	}
	
	//Hashtable
	
	
	@DataProvider
	public static Object[][] getData(){
		
		
		
		  if(excel == null){
		  
		  
			  excel=new ReadExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\excels\\CustomerDetails.xlsx");
		  
		  
		  }
		 
		
		String sheetName="AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++){
			
			table = new Hashtable<String,String>();
			
			for(int colNum=0; colNum<cols; colNum++){
				
		//	data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
		
			table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));	
			data[rowNum-2][0]=table;	
				
			}
			
		}
		
		
		return data;
		
		
	}
	}
