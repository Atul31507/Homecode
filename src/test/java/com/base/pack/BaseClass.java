package com.base.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	private WebDriver driver;
	String Chromepath = "";


	public WebDriver getdriver()
	{
		return driver;

	}

	private void  setDriver(String browsername,String appUrl)
	{
		switch(browsername)
		{
		case "chrome":
			driver = initchromedriver(appUrl); 
			break;
		case"firefox":
			driver = initfirfoxdriver(appUrl);
			break;
		default:
			System.out.println("browser "+browsername+"is of invalid type hence lauching firefox driver");
			driver = initfirfoxdriver(appUrl);
		}

	}
	private  WebDriver initchromedriver(String appUrl)
	{
		System.setProperty("webdriver.chrome.driver", "path");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appUrl);

		return driver;
	}
	private WebDriver initfirfoxdriver(String appUrl)
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appUrl);
		return driver;
	}
	@Parameters({"browserType","appURL"})
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
