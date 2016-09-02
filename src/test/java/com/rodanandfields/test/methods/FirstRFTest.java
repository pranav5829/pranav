package com.rodanandfields.test.methods;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rodanandfields.pages.BasePage;
import com.rodanandfields.pages.HomePage;
import com.rodanandfields.pages.QuickShopPage;
import com.rodanandfields.test.base.TestBaseClass;


public class FirstRFTest extends TestBaseClass {

	public BasePage basePage;
	public HomePage homePage;
	public QuickShopPage QuickShopPage;
	
	@Test
	public void selectProductTest() throws InterruptedException{
		basePage = new BasePage(driver);
		homePage = new HomePage(driver);
		QuickShopPage = new QuickShopPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage.clickOnShopSkinCare();
		homePage.clickOnAllProducts();
		Assert.assertTrue(QuickShopPage.verifyUserIsOnQuickShopPage(), "User is not on Quick Shop Page");
		QuickShopPage.selectProductDropdown();
		QuickShopPage.selectRedefineFromDropdown();
		QuickShopPage.selectProductDropdown();
		QuickShopPage.selectReverseFromDropdown();
		QuickShopPage.selectPriceFromDropdown();
		Assert.assertTrue(QuickShopPage.verifyRedefineLabelIsPresent(), "Rdefine Label is not present");
		Assert.assertTrue(QuickShopPage.verifyReverseLabelIsPresent(), "Rdefine Label is not present");
		Assert.assertTrue(QuickShopPage.verifyRedefineBoxeIsChecked(), "Redefinecheckbox is not checked");
		Assert.assertTrue(QuickShopPage.verifyReverseBoxeIsChecked(), "Redefinecheckbox is not checked");
		Assert.assertTrue(QuickShopPage.verifyProductsPriceRange(), "price is in the range of selected price filter");
		
		
	}
	

}
