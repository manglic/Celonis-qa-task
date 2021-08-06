package com.celonis.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProcessAnalyticsPage extends BasePage{
	
	/**
	 * Constructor calls super class(BasePage) constructor.
	 */
	public ProcessAnalyticsPage(WebDriver webDriver) {
		super(webDriver);
		System.out.println("Initiated SBLoginPage web elements");
	}

	

	/*
	 * Web Elements...
	 */
	
	private static String pageTitle = "Workspaces | Process Analytics";
	
	@FindBy(xpath = "//span[contains(text(),'--> Pizza Demo')]")
    private WebElement pizzaDemo;
	
	@FindBy(xpath = "//span[contains(text(),'--> SAP ECC - Order to Cash')]")
    private WebElement orderToCashDemo;
	
	@FindBy(xpath = "//span[contains(text(),'--> SAP ECC - Purchase to Pay')]")
    private WebElement purchaseToPayDemo;
	
	@FindBy(xpath = "//span[contains(text(),'--> ServiceNow Ticketing')]")
    private WebElement serviceNowTicketingDemo;
	
	@FindBy(xpath = "//a[@class='ce-tile__link ng-star-inserted']")
    private WebElement demoAnalysisLink;
	
	/*
	 * Functions to perform action on Web Elements...
	 */
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	public boolean isPizzaDemoVisible() {
		return waitForElementVisible(pizzaDemo, 10);
	}

	public boolean isOrderToCashDemoVisible() {
		return waitForElementVisible(orderToCashDemo, 10);
	}

	public boolean isPurchaseToPayDemoVisible() {
		return waitForElementVisible(purchaseToPayDemo, 10);
	}

	public boolean isServiceNowTicketingVisible() {
		return waitForElementVisible(serviceNowTicketingDemo, 10);
	}

	public ProcessAnalysisPage clickPizzaDemo() {
		clickElement(pizzaDemo, 10);
		clickElement(demoAnalysisLink, 10);
		ProcessAnalysisPage processAnalysisPage = new ProcessAnalysisPage(webDriver);
		if(processAnalysisPage.waitForPageToLoad(processAnalysisPage.getPageTitle(), 30))
			return processAnalysisPage;
		return null;
	}
	
	public ProcessAnalysisPage clickOrderToCashDemo() {
		clickElement(orderToCashDemo, 10);
		clickElement(demoAnalysisLink, 10);
		ProcessAnalysisPage processAnalysisPage = new ProcessAnalysisPage(webDriver);
		if(processAnalysisPage.waitForPageToLoad(processAnalysisPage.getPageTitle(), 10))
			return processAnalysisPage;
		return null;
	}
	
	public ProcessAnalysisPage clickPurchaseToPayDemo() {
		clickElement(purchaseToPayDemo, 10);
		clickElement(demoAnalysisLink, 10);
		ProcessAnalysisPage processAnalysisPage = new ProcessAnalysisPage(webDriver);
		if(processAnalysisPage.waitForPageToLoad(processAnalysisPage.getPageTitle(), 10))
			return processAnalysisPage;
		return null;
	}
	
	public ProcessAnalysisPage clickServiceNowTicketingDemo() {
		clickElement(serviceNowTicketingDemo, 10);
		clickElement(demoAnalysisLink, 10);
		ProcessAnalysisPage processAnalysisPage = new ProcessAnalysisPage(webDriver);
		if(processAnalysisPage.waitForPageToLoad(processAnalysisPage.getPageTitle(), 10))
			return processAnalysisPage;
		return null;
	}
}
