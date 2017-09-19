package com.gmail.constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class GmailConstants {

	public static WebDriver driver;

	@BeforeSuite
	public void getBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@BeforeTest
	public static void launchApp() {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public static void endTest() {
		/* closing driver object to close the browser */
		driver.close();
	}

	@AfterSuite(enabled = true)
	public void closeApp() {
		driver.quit();
	}
}
