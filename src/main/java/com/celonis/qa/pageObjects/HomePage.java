package com.celonis.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class HomePage extends BasePage{
	
	/**
	 * Constructor calls super class(BasePage) constructor.
	 */
	public HomePage(WebDriver webDriver) {
		super(webDriver);
		System.out.println("Initiated SBLoginPage web elements");
	}

	
	/*
	 * Web Elements...
	 */
	private static String pageTitle = "Business Views";
	
	@FindBy(xpath = "//span[contains(text(),'Process Analytics')]")
    private WebElement processAnalyticsTab;
	
	
	/*
	 * Functions to perform action on Web Elements...
	 */
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	@Step("Click Process Analytics Page")
	public ProcessAnalyticsPage clickAnalyticsTab(){
		clickElement(processAnalyticsTab, 10);
		ProcessAnalyticsPage processAnalyticsPage = new ProcessAnalyticsPage(webDriver);
		if(processAnalyticsPage.waitForPageToLoad(processAnalyticsPage.getPageTitle(), 10))
			return processAnalyticsPage;
		else
			return null;
	}

}
