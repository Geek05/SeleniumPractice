package org.util.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.util.selenium.Common.Browser;

public class CommonUtils {
	
	public static WebDriver driver = null;
	
	static {
		System.out.println("static block loaded");
		SeleniumDriver.setDriverType(Browser.CHROME);
		driver = SeleniumDriver.GetDriver();
		System.out.println("static block loaded "+driver);
	}
	
	public static void Quit() {
		SeleniumDriver.CloseDriver();
	}
	
	public static void captureSceenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile , new File(System.getProperty("user.dir")+"\\screen\\capturescreen.jpg"));
	}
	
	public static void OpenPage(String URL) {
		System.out.println("OpenPage block loaded");
		driver.get(URL);
	}

}
