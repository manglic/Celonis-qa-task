package com.celonis.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProcessAnalysisPage extends BasePage{
	
	/**
	 * Constructor calls super class(BasePage) constructor.
	 */
	public ProcessAnalysisPage(WebDriver webDriver) {
		super(webDriver);
		System.out.println("Initiated SBLoginPage web elements");
	}

	

	/*
	 * Web Elements...
	 */
	private static String pageTitle = "Challenge_Ankit.M | Process Analytics";
	
	@FindBy(xpath = "//i[@title='Settings']")
    private WebElement pizaDemoAnalysisSettings;
	
	@FindBy(xpath = "//button[contains(text(),'Edit KPI')]")
	private WebElement purchaseToPayAnalysisEditKpi;
	
	
	/*
	 * Functions to perform action on Web Elements...
	 */
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	public boolean isPizzaDemoAnalysisSettingsLinkVisible() {
		return waitForElementVisible(pizaDemoAnalysisSettings, 10);
	}

	public boolean isPurchaseToPayEditKpiLinkVisible() {
		return waitForElementVisible(purchaseToPayAnalysisEditKpi, 10);
	}
}
