package com.celonis.qa.utils;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;


import io.qameta.allure.Attachment;
import com.celonis.qa.pageObjects.*;

/**
 * @author ankit.manglic
 * Class extends TestNG listener class to perform various operation, as defined below, during different state of test case:
 * - update the pass and fail status for allure report.
 * - Add screenshot to allure report on every test failure
 * - update test execution status in test rail with the test case Id.
 */
public class AllureReportListener implements ITestListener{
	
	// return test method name
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	// return test case id for a particular test. 
//	private static String getTestMethodAnnotation(ITestResult iTestResult) {
//		String TestID="0";
//		try {
//			IClass obj = iTestResult.getTestClass();
//			Class newobj = obj.getRealClass();
//			Method testMethod = newobj.getMethod(iTestResult.getName());
////			if (newobj.getMethod(iTestResult.getName()).isAnnotationPresent(UseAsTestRailId.class))
////			if (testMethod.isAnnotationPresent(UseAsTestRailId.class))
////			{
//////				UseAsTestRailId useAsTestName = newobj.getMethod(iTestResult.getName()).getAnnotation(UseAsTestRailId.class);
////				UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
////				// Get the TestCase ID for TestRail
////				TestID = Integer.toString(useAsTestName.testRailId());
////				System.out.println("Test Rail ID = " + TestID);
////			}
//			return TestID;
//		}
//		catch(Exception e) {
//			System.out.println("Exception generated while fetching test annotation for a test. Error->"+e);
//			return TestID;
//		}
//	}
	
	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver",  BasePage.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BasePage.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}
