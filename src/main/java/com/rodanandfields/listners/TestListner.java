package com.rodanandfields.listners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListner implements ITestListener {
	
	WebDriver driver=null;
	String filePath = System.getProperty("user.dir")+ "\\output\\ScreenShots\\";

	public void onTestStart(ITestResult result) {
		Reporter.log("--------About to begin executing Test " + result.getName(), true);
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("--------Following Test has passed " + result.getName(), true);
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String sFilename = null;
		sFilename = "Screenshot-"+".png";
		String FullSnapShotFilePath = System.getProperty("user.dir")
				+ "\\output\\ScreenShots\\" + sFilename;
				try {
					FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
