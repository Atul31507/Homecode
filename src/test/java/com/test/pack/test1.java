package com.test.pack;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utils.pack.SupportUtils;
import com.base.pack.BaseClass;
import com.base.pack.BrowserEventManager;

public class test1 extends com.test.pack.BaseClass {

	@Test
	public void testpage() throws Exception
	{
		//Assert.assertTrue(0>1);
		event.screenshot("test");
		System.out.println("start the frame work");

	}
}
