package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='j_username']")
	private WebElement userNameElement;
	
	@FindBy(how=How.CSS, using=".normal[name='j_password']")
	private WebElement passwordElement;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	private WebElement submitElement;
	
	public void EnterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}
	
	public void EnterPassWord(String password) {
		passwordElement.sendKeys(password);
	}
	
	public void login(String userName, String password) throws InterruptedException {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		submitElement.submit();
		
		//Actions action = new Actions(driver);		
	}	
}
