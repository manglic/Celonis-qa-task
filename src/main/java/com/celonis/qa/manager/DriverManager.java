package com.celonis.qa.manager;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver getDriver(String browser, String remoteUrl, boolean runLocal) {
		switch(browser)
        {
            case "chrome":
            	if(runLocal) {
   				 	WebDriverManager.chromedriver().setup();
   				 	return new ChromeDriver();
   			 	}
   			 	else {
   			 		try {
   			 			return new RemoteWebDriver(new URL(remoteUrl), BrowserManager.getChromeBrowserCaps());
   			 		}
   			 		catch(Exception e) {
   			 			System.out.println("Exception generated while connecting to Remote URL.");
   			 			return null;
   			 		}
   				 }
            	
            case "firefox":
            	if(runLocal) {
            		WebDriverManager.firefoxdriver().setup();
   				 	return new FirefoxDriver();
   			 	}
   			 	else {
   			 		try {
   			 			return new RemoteWebDriver(new URL(remoteUrl), BrowserManager.getFirefoxOptions());
   			 		}
   			 		catch(Exception e) {
   			 			System.out.println("Exception generated while connecting to Remote URL.");
   			 			return null;
   			 		}
   				 }
            	
            case "ie":
                //#ToDo
                return null;
                
            case "safari":
                //#ToDo
            	return null;
            	
            default:
                System.out.println("wrong Browser choice");
                return null;
        }
    }
	
	
	public static WebDriver getDriver(String browser) {
		switch(browser)
        {
            case "chrome":
   				 	WebDriverManager.chromedriver().setup();
   				 	return new ChromeDriver();
            	
            case "firefox":
            		WebDriverManager.firefoxdriver().setup();
   				 	return new FirefoxDriver();
            	
            case "ie":
                //#ToDo
                return null;
                
            case "safari":
                //#ToDo
            	return null;
            	
            default:
                System.out.println("wrong Browser choice");
                return null;
        }
    }

}
