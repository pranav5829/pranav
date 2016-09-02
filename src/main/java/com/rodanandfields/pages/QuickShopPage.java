package com.rodanandfields.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rodanandfields.utils.CommonUtilities;

import net.sf.cglib.core.CollectionUtils;

public class QuickShopPage extends BasePage{

	public QuickShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;	

	public static final By PRODUCT_DROPDOWN = By.xpath("//input[@class='refine-products-button'][contains(@value,'Product(s)')]");
	public static final By REDEFINE_FROM_DROPDOWN = By.xpath("//div[contains(text(),'REDEFINE')]//following::input[@id='REDEFINE'][1]");	
	public static final By PRICE_DROPDOWN = By.xpath("//input[@class='refine-products-button'][contains(@value,'- Price -')]");
	public static final By REVERSE_FROM_DROPDOWN = By.xpath("//div[contains(text(),'REDEFINE')]//following::input[@id='REVERSE'][1]");
	public static final By SELECT_PRICE_FROM_DROPDOWN = By.xpath("//div[contains(text(),'CAD$50 TO CAD$199.99')]/following::div[@class='pull-right'][1]");
	public static final By REDEFINE_LABEL = By.xpath("//label[@for='REDEFINE']");
	public static final By REDEFINE_CHECKBOX = By.xpath("//label[@for='REDEFINE']/preceding::div[1]");
	public static final By REVERSE_LABEL = By.xpath("//label[@for='REVERSE']");
	public static final By REVERSE_CHECKBOX = By.xpath("//label[@for='REVERSE']/preceding::div[1]");
	public static final By SELECT_ALL_PRODUCTS = By.xpath("//div[@id='main-content']//div[@class='quick-shop-section-header']/following::div[@class='quick-product-wrapper row product-catalogue'][1]/div");
	public static String  PRODUCT_PRICE = "//div[@id='main-content']//div[@class='quick-shop-section-header']/following::div[@class='quick-product-wrapper row product-catalogue'][1]/div[%s]/p";




	public boolean verifyUserIsOnQuickShopPage(){
		if(driver.getCurrentUrl().contains("quickShop")){
			return true;
		}
		else
			return false;
	}

	public void selectProductDropdown() throws InterruptedException{
		driver.findElement(PRODUCT_DROPDOWN).click();
		Thread.sleep(2000);
	}

	public void selectRedefineFromDropdown() throws InterruptedException{
		driver.findElement(REDEFINE_FROM_DROPDOWN).click();
		Thread.sleep(2000);

	}

	public void selectReverseFromDropdown() throws InterruptedException{
		driver.findElement(REDEFINE_FROM_DROPDOWN).click();
		Thread.sleep(2000);

	}

	public void selectPriceFromDropdown() throws InterruptedException{
		driver.findElement(PRICE_DROPDOWN).click();
		Thread.sleep(2000);
		driver.findElement(SELECT_PRICE_FROM_DROPDOWN).click();;
	}


	public boolean verifyReverseLabelIsPresent(){
		WebElement reverseLabelElement = driver.findElement(REVERSE_LABEL);
		if(reverseLabelElement.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}

	public boolean verifyRedefineLabelIsPresent(){
		WebElement redefineLabelElement = driver.findElement(REDEFINE_LABEL);
		if(redefineLabelElement.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}

	public boolean verifyReverseBoxeIsChecked(){
		WebElement reverseCheckboxElement = driver.findElement(REVERSE_CHECKBOX);
		if(reverseCheckboxElement.isSelected())
		{
			return true;
		}
		else
			return false;
	}

	public boolean verifyRedefineBoxeIsChecked(){
		WebElement redefineCheckboxElement = driver.findElement(REDEFINE_CHECKBOX);
		if(redefineCheckboxElement.isSelected())
		{
			return true;
		}
		else
			return false;
	}

	public boolean verifyProductsPriceRange(){
		int numberofProducts =driver.findElements(SELECT_ALL_PRODUCTS).size();
		for(int i = 1;i<=numberofProducts;i++){
			String Price = driver.findElement(By.xpath(String.format(PRODUCT_PRICE,i))).getText();
			String []split = Price.split("CAD")[1].split("$");
			int value = Integer.parseInt(split[0]);
			if(value>50){
				return true;
					}
			
	}
		return false;
		
}
}
