package com.test.pack;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utils.pack.SupportUtils;
import com.base.pack.BrowserEventManager;

public class BaseClass {

	protected BrowserEventManager event;
	protected WebDriver driver;
	protected Properties prop;

	@BeforeClass
	public void setup() throws Exception
	{
		event = new BrowserEventManager();
		driver= event.getWebDriver();
		prop = SupportUtils.getproperty();
		driver.get(prop.getProperty("URL"));
		
	}
	
	@AfterMethod
	public void Testresult(ITestResult result) throws IOException
	{
		if(result.equals(ITestResult.FAILURE))
		{
			event.screenshot(result.getTestName());
		}
		
	}
}
