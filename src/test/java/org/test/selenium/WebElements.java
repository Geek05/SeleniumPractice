package org.test.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.util.selenium.CommonUtils;

public class WebElements {
	
	WebElement element = null;
	WebDriver driver = CommonUtils.driver;
	
	@Test(priority=0 , enabled=false)
	public void testDropDown() throws InterruptedException {
		CommonUtils.OpenPage("https://www.wikipedia.org/");
		element = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(element);  // <select name="abc"> <option name='b'>Banana<option> 
		select.selectByValue("hi");
		Thread.sleep(5000);
		
		for(WebElement option: select.getOptions()) {
			System.out.println(option.getAttribute("lang")+"  "+option.getText());
		}		
	}
	
	
	@Test(priority=1 , enabled=false)
	public void testGetAllLinks() throws IOException  {
		try
		{
			CommonUtils.OpenPage("https://www.wikipedia.org/");
			WebElement blockElements = driver.findElement(By.xpath("//*[@class='footer' and @data-el-section='other projects']a"));
			List<WebElement> elements = blockElements.findElements(By.tagName("a"));

			for(WebElement element : elements) {
				System.out.println(element.getText() +" "+ element.getAttribute("href"));
			}
		}
		catch(Exception e) {
			CommonUtils.captureSceenshot();
		}

	}
	
	@Test(priority=2 , enabled=false)
	public void testRadioButtons() throws InterruptedException {
		CommonUtils.OpenPage("https://www.quackit.com/html/codes/html_radio_button.cfm");
		List<WebElement> radio_Button = driver.findElements(By.name("preferred_item"));
		System.out.println(radio_Button.size());
		for(WebElement element : radio_Button) {
			System.out.println(element.getText());			
			Thread.sleep(1000);
		}
		
	}
	
	
	@Test(priority=2 , enabled=false)
	public void testExplicitWait() throws InterruptedException {
		CommonUtils.OpenPage("https://www.google.com/");
		WebElement element = driver.findElement(By.cssSelector("input.gsfi[name='q']"));
		element.sendKeys("Selenium");
		//Thread.sleep(5000);		
		element = driver.findElement(By.xpath("//*[contains(text(),'grid2')]"));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	
	@Test(priority=2 , enabled=true)
	public void testFluentWait() throws InterruptedException {
		CommonUtils.OpenPage("https://www.google.com/");
		WebElement element = driver.findElement(By.cssSelector("input.gsfi[name='q']"));
		element.sendKeys("Selenium");
		//Thread.sleep(5000);		
		element = driver.findElement(By.xpath("//*[contains(text(),'grid2')]"));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(10, TimeUnit.SECONDS).
				pollingEvery(5, TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	
	
	@AfterTest
	public void tearDown() {
		CommonUtils.Quit();
	}
	

}
