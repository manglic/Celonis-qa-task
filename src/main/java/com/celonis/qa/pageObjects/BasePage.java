package com.celonis.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.celonis.qa.utils.PropertiesUtil;

import io.qameta.allure.Step;

public class BasePage {
	
	public WebDriver webDriver;
	public static WebDriver driver;
	
	public PropertiesUtil propertiesUtil;
	
	/**
	 * Constructor takes @param webDriver of class WebDriver.
	 */
	public BasePage(WebDriver webDriver) {
		this.webDriver =  webDriver;
		//PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 100), this);
		PageFactory.initElements(webDriver, this);
		BasePage.driver = webDriver;
		
		propertiesUtil = new PropertiesUtil();
	}
	
	
/** Wait Functions **/
	
	/**
	 * Function wait for @param secs , till @param element is available.
	 */
	public void waitForElementAvailable(WebElement element, int secs){
		try {
			System.out.println("waiting for element to be available . Element - "+element);
			new WebDriverWait(webDriver, secs).until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			System.out.println("Exception generated while waiting for availability of element ->"+element+" . Error->"+e);
		}
	}

	/**
	 * Function wait for @param secs , till @param element is visible.
	 */
	public boolean waitForElementVisible(WebElement element, int secs){
		try {
			System.out.println("waiting for element to be visible . Element - "+element);
			new WebDriverWait(webDriver, secs).until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception generated while waiting for visibility of element ->"+element+" . Error->"+e);
			return false;
		}
	}
	
	/**
	 * Function wait for new page to load completely  after a click and wait till element @Param pageTitleStr is available.
	 */
	public boolean waitForPageToLoad(String pageTitleStr, int waitSec) {
		try {
			System.out.println("waiting for Page to load with page title - "+pageTitleStr);
			String xpathStr = String.format("//title[contains(text(),'%s')]", pageTitleStr);
			waitForElementAvailable(webDriver.findElement(By.xpath(xpathStr)), waitSec);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception generated while waiting for page to load with page Title -"+pageTitleStr+" . Error->"+e);
			return false;
		}
    }
	
	/**
	 * Function wait for new page to load completely  after a click and wait till element @Param pageTitleStr is available.
	 */
	public void waitForPageToLoad(WebElement element, int waitSec) {
		try {
			System.out.println("waiting for Page to load with element - "+element);
			waitForElementAvailable(element, waitSec);
		}
		catch(Exception e){
			System.out.println("Exception generated while waiting for page to load with page Title -"+element+" . Error->"+e);
		}
    }
	
	/**
	 * Function wait for @param secs , till @param element is clickable.
	 */
	public void waitForElementclickable(WebElement element, int secs){
		try {
			System.out.println("waiting for element to be clickable . Element - "+element);
			new WebDriverWait(webDriver, secs).until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
			System.out.println("Exception generated while waiting for clickable state of element ->"+element+" . Error->"+e);
		}
	}
	
	/**
	 * @param url : Complete URL of the web page
	 * Function opens the Web page for the URL passed in param.
	 */
	 @Step("Open URL {0}")
	public void openUrl(String url) {
		webDriver.get(url);
	}
	 
	 /**
		 * Function wait for element to be visible and then enter the provided string in field.
		 * @param string
		 * @param element
		 */
		public void enterString(String string, WebElement element, int waitSec) {
			waitForElementVisible(element,waitSec);
			element.clear();
			element.sendKeys(string);
			System.out.println("Entering text "+string+" in element "+element);
		}
		
		/**
		 * Function wait for element to be clickable and then click on element.
		 * @param element
		 */
		public void clickElement(WebElement element, int waitSec) {
			waitForElementclickable(element,waitSec);
			element.click();
			System.out.println("Clicked on element "+element);
		}
		
		/**
		 * Function returns the driver Object.
		 * @return
		 */
		public static WebDriver getDriver() {
			System.out.println("Returning driver reference.");
			return driver;
		}
}
