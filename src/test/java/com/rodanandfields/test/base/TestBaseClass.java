package com.rodanandfields.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClass {

	public WebDriver driver;

	@BeforeMethod
	public void openUrl(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rodanandfields.com/ca");
		
	}
	
	@AfterMethod
	public void close(){
		driver.quit();
	}
}
