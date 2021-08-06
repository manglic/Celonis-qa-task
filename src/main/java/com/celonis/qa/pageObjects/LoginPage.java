package com.celonis.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	/**
	 * Constructor calls super class(BasePage) constructor.
	 */
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		System.out.println("Initiated SBLoginPage web elements");
	}

	

	/*
	 * Web Elements...
	 */
	
	@FindBy(name = "username")
    private WebElement usernameField;
	
	@FindBy(name = "password")
    private WebElement passwordField;
	
	@FindBy(xpath = "//button[@cetestinguid='login-form-submit-button']")
    private WebElement loginBtn;
	
	
	
	/*
	 * Functions to perform action on Web Elements...
	 */
	
	@Step("Enter shop backend username")
	public void enterUsername(String username){
		enterString(username , usernameField, 10);
	}
	
	@Step("Enter shop backend password")
	public void enterPassword(String password) {
		enterString(password, passwordField, 10);
	}
	
	@Step("Click login button")
	public void clickLoginButton() {
		clickElement(loginBtn, 10);
	}
	
	public HomePage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
		HomePage homePage = new HomePage(webDriver);
		if(homePage.waitForPageToLoad(homePage.getPageTitle(), 10))
			return homePage;
		else
			return null;
	}

}
