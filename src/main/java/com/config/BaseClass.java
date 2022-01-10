package com.config;


import static com.Utility.UIkeywords.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
//	UIkeywords keyword =  UIkeywords.getInstance();
	@BeforeMethod
	public void setUp() {
		openBrowser("chrome");
		getDriver().manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quitBrowser();
	}
}
