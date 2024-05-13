package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public static ExtentTest gettest() {
		return test.get();
	}
	
	
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}

	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	public static void setDrivert(WebDriver actdriver) {
		driver.set(actdriver);
	}
}
