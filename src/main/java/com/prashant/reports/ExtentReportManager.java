package com.prashant.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager() {

	}

	static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}

}
