package com.celonis.qa.manager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserManager {

	public static DesiredCapabilities getChromeBrowserCaps() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); // ChromeOptions for starting chrome in incognito mode

		caps.setCapability(ChromeOptions.CAPABILITY, options);
		// other capability declarations
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Big Sur");
		caps.setCapability("resolution", "1920x1080");

		return caps;
	}

	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions ffOptions = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "fr"); // Setting the locale language to accept French
		profile.setPreference("plugin.state.flash", 0); // Disabling Flash using Firefox profile
		// More profile settings can be set using statements like above
		ffOptions.setProfile(profile);
		ffOptions.setCapability("browser", "Firefox");
		ffOptions.setCapability("os", "Windows");
		ffOptions.setCapability("resolution", "1920x1080");

		return ffOptions;
	}
	
	//#ToDo
	/*
	 * Implement IE, Safari and other browsers functions.
	 */

}
