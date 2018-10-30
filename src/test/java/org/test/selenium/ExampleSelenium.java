package org.test.selenium;

import java.lang.ref.PhantomReference;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class ExampleSelenium {
	
	WebDriver driver = null;
	
	@Test
	public void testSelenium() {
		try
		{			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Externals/chromedriver.exe");
			System.setProperty("phantomjs.binary.path", System.getProperty("user.dir")+"/Externals/phantomjs.exe");
			System.out.println(System.getProperty("webdriver.chrome.driver"));
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-notifications");
			//driver = new ChromeDriver(options);
			
			driver = new PhantomJSDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.get("https://www.myntra.com/");			
			Thread.sleep(2000);
			System.out.println("Title = "+driver.getTitle()); 
			
			
			//handle window popup
			//System.out.println(driver.switchTo().alert().getText());
			//driver.switchTo().alert().dismiss();
			
			//hover
			Actions action = new Actions(driver);
			WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
			WebElement sportsShoes = driver.findElement(By.xpath("//a[@data-reactid=73 and text()='Sports Shoes']"));
			action.moveToElement(men).moveToElement(sportsShoes).click().build().perform();;
			Thread.sleep(3000);
		}
		catch(Exception e) {
			System.err.println(e);
		}
		finally {
			if(driver!=null)
			{
				driver.close();
				driver.quit();
				driver = null;
			}
		}
	}

}
