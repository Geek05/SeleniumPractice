package org.util.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.util.selenium.Common.Browser;

public class SeleniumDriver {
	
	public static WebDriver driver = null;
	static Browser browserType; 
	
	public static void setDriverType(Browser browser) {
		browserType = browser;
	}	
	
	public static WebDriver GetDriver() {
		if(driver==null) {
			switch(browserType) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Externals/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			default:			
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Externals/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
			setDriverDefaults();
		}
		return driver;
	}
	
	private static void setDriverDefaults() {
		if(driver!=null) {
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.manage().window().maximize();			
		}
	}

	public static void CloseDriver() {
		if(driver!=null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}	

}
