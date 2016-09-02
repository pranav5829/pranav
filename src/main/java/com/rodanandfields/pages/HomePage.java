package com.rodanandfields.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HomePage extends BasePage {


	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	WebDriver driver;

	public static final By SHOP_SKINCARE_BUTTON = By.id("our-products");
	public static final By ALL_PRODUCTS = By.xpath("//ul[@id='dropdown-menu']//*[contains(text(),'All Products')]");

	public void clickOnShopSkinCare() throws InterruptedException{
		driver.findElement(SHOP_SKINCARE_BUTTON).click();
		Reporter.log("Shop Skincare Button Clicked");
		Thread.sleep(3000);

	}
	
	public void clickOnAllProducts(){
		driver.findElement(ALL_PRODUCTS).click();
		Reporter.log("All product Link Button Clicked");
	}
}
