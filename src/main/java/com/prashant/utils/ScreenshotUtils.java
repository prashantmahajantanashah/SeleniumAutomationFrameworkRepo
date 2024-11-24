package com.prashant.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.prashant.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils(){
		
	}
	
	public static String getScreenshotBase64() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
