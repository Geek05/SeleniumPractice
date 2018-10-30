package org.test.selenium;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.util.selenium.CommonUtils;

public class LoginTest {
		
	@BeforeTest
	public void setUp() {
		CommonUtils.OpenPage("http://localhost:9090/login?from=%2F");
	}
	
	@AfterTest
	public void tearDown() {
		CommonUtils.Quit();
	}
	
	@Test(enabled=false)
	public void testLogin() {
		WebElement element = null;
		try
		{			
			element = CommonUtils.driver.findElement(By.xpath("//input[@id='j_username']"));
			element.sendKeys("admin");
			element = CommonUtils.driver.findElement(By.xpath("//input[@name='j_password']"));
			element.sendKeys("admin");
			element.submit();
			assertEquals(CommonUtils.driver.getTitle(), "Dashboard [Jenkins]");
		}
		catch(Exception e) {
			System.err.println(ExceptionUtils.getStackTrace(e));
		}		
	}
	
	
	@Test(enabled=true)
	public void testLoginPOM() {
		try {
			LoginPage loginPage = new LoginPage(CommonUtils.driver);
			loginPage.login("admin", "admin");
			Thread.sleep(1000);
			assertEquals(CommonUtils.driver.getTitle(), "Dashboard [Jenkins]");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.err.println(ExceptionUtils.getStackTrace(e));
		}
	}
}
