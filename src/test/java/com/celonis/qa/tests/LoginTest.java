package com.celonis.qa.tests;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

import com.celonis.qa.pageObjects.HomePage;
import com.celonis.qa.pageObjects.LoginPage;
import com.celonis.qa.utils.AllureReportListener;

@Listeners({AllureReportListener.class})
public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
	@Parameters({"browserType"})
	@BeforeClass
	@Description("Enable webdriver")
	public void setPrerequisites(String browserType) {
		setup(browserType);
		loginPage = new LoginPage(webDriver); 
		loginPage.openUrl(properties.getProperty("AppUrl"));
	}
	
	@Test(priority = 0)
	@Description("Try to Login into the application with invalid user")
	public void loginTest_invalidUser() {
		Object obj = loginPage.login(properties.getProperty("username"), properties.getProperty("invalidPassword"));
		
		Assert.assertFalse("User is not logged into the application", obj instanceof HomePage);
	}
	
	@Test(priority = 1)
	@Description("Login into the application with valid user")
	public void loginTest_validUser() {
		Object obj = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
		Assert.assertTrue("User is successfully logged into the application", obj instanceof HomePage);
	}

	@AfterClass
	@Description("Set Test specific values to default")
	public void setToDefault() {
		tearDown();
	}

}
