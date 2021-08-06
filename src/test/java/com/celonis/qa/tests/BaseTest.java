package com.celonis.qa.tests;

import com.celonis.qa.manager.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import com.celonis.qa.utils.*;

public class BaseTest {
	
	public WebDriver webDriver;
	public PropertiesUtil properties;
	
	/**
	 * @param browserType : chrome' , 'firefox' , 'ie' , 'safari'
	 */
	@Step("Open Browser {0}")
	 public void setup(String browserType){
		webDriver = DriverManager.getDriver(browserType);
		webDriver.manage().window().maximize();
		properties = new PropertiesUtil();
//		System.out.println(properties.getProperty("ImlicitWaitSec"));
//		webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("ImlicitWaitSec")), TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 }
	
	@Step("Open Browser {0} on remote url {1}")
	 public void setup(String browserType, String remoteUrl){
		webDriver = DriverManager.getDriver(browserType, remoteUrl, false);
	 }
	
	/**
	 * Function closed the browser and quit the driver
	 */
	@Step("Close Browser session")
	public void closeBrowserSession(){
		 webDriver.close();
	 }
	
	 /**
	 * Function closed the browser and quit the driver
	 */
	@Step("Quit WebDriver")
	public void tearDown(){
		 webDriver.quit();
	 }

}
