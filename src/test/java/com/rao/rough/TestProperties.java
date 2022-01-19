package com.rao.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		Properties config=new Properties();
		Properties OR=new Properties();
		
		FileInputStream cfis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(cfis);
		System.out.println(config.getProperty("browser"));
		
		FileInputStream ORfis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(ORfis);
		System.out.println(OR.getProperty("buttonManager"));
		
	}

}
