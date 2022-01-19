package com.rao.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.rao.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/*
	 * WebDriver creation
	 * Properties
	 * Logs
	 * Reports
	 * DB connection
	 * Excel
	 * Mail
	 * Reports(TestNG,ExtentReports)
	 */
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	//public static ReadExcel excel=new ReadExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\excels\\CustomerDetails.xlsx");
	
	@BeforeSuite
	public void setup() throws Throwable
	{
		if(driver==null)
		{
			log.debug("config file loading");
			FileInputStream cfis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(cfis);
			
			
			FileInputStream ORfis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(ORfis);
			
			log.info("Config files loaded sucesfully");
			
		}
		if(config.getProperty("browser").equals("chrome"))
		{ 
			log.debug("Chrome launched");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		if(config.getProperty("browser").equals("edge"))
		{ 
			log.debug("edge launched");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		driver.get(config.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.Wait")), TimeUnit.SECONDS);
		
	}
	
	public boolean isElementPresent(By by)
	{
		try {
		driver.findElement(by);
		return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	@AfterSuite
	public void tearDown() {
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
}
