package com.celonis.qa.tests;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.celonis.qa.pageObjects.HomePage;
import com.celonis.qa.pageObjects.LoginPage;
import com.celonis.qa.pageObjects.ProcessAnalysisPage;
import com.celonis.qa.pageObjects.ProcessAnalyticsPage;
import com.celonis.qa.utils.AllureReportListener;

import io.qameta.allure.Description;

@Listeners({AllureReportListener.class})
public class DemoAnalysisTest extends BaseTest{

	LoginPage loginPage;
	HomePage homePage;
	ProcessAnalyticsPage processAnalyticsPage;
	
	@Parameters({"browserType"})
	@BeforeClass
	@Description("Enable webdriver")
	public void setPrerequisites(String browserType) {
		setup(browserType);
		loginPage = new LoginPage(webDriver); 
		loginPage.openUrl(properties.getProperty("AppUrl"));
	}
	
	@Test(priority = 0)
	@Description("Verify All analysis are available on Analytics page")
	public void validateAllAnalysisArePresent() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		processAnalyticsPage  = homePage.clickAnalyticsTab();
		
		Assert.assertTrue("Validate Pizza Demo Analysis is Present", processAnalyticsPage.isPizzaDemoVisible());
		Assert.assertTrue("Validate Order to cash Analysis is Present", processAnalyticsPage.isOrderToCashDemoVisible());
		Assert.assertTrue("Validate Purchase to Pay Analysis is Present", processAnalyticsPage.isPurchaseToPayDemoVisible());
		Assert.assertTrue("Validate Service Now Ticketing Analysis is Present", processAnalyticsPage.isServiceNowTicketingVisible());
	}
	
	@Test(priority = 1, dependsOnMethods = "validateAllAnalysisArePresent")
	@Description("Validate Pizza Demo Analysis Page is displayed")
	public void validatePizzaDemoAnalysisIsLoaded() {
		
		ProcessAnalysisPage processAnalysisPage = processAnalyticsPage.clickPizzaDemo();
		
		Assert.assertTrue("Validate Pizza Demo Analysis page is loaded", processAnalysisPage instanceof ProcessAnalysisPage);
		Assert.assertTrue("Validate Pizza Demo Analysis page settings menu is loaded", processAnalysisPage.isPizzaDemoAnalysisSettingsLinkVisible());
		
		webDriver.navigate().back();
	}
	
	@Test(priority = 2, dependsOnMethods = "validateAllAnalysisArePresent")
	@Description("Validate Purchase TO Pay Analysis Page is displayed")
	public void validatePurchaseToPayAnalysisIsLoaded() {
		
		ProcessAnalysisPage processAnalysisPage = processAnalyticsPage.clickPurchaseToPayDemo();
		
		Assert.assertTrue("Validate Purchase to Pay Analysis page is loaded", processAnalysisPage instanceof ProcessAnalysisPage);
		Assert.assertTrue("Validate Purchase To Pay Edit Kpi link is loaded", processAnalysisPage.isPurchaseToPayEditKpiLinkVisible());
		webDriver.navigate().back();
	}
	
	@Test(priority = 3, dependsOnMethods = "validateAllAnalysisArePresent")
	@Description("Validate Order To cash Analysis Page is displayed")
	public void validateOrderToCashAnalysisIsLoaded() {
		
		ProcessAnalysisPage processAnalysisPage = processAnalyticsPage.clickOrderToCashDemo();
		
		Assert.assertTrue("Validate Order to Cash Analysis page is loaded", processAnalysisPage instanceof ProcessAnalysisPage);
		
		webDriver.navigate().back();
	}
	
	
	
	@AfterClass
	@Description("Set Test specific values to default")
	public void setToDefault() {
		tearDown();
	}
}
