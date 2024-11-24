package com.prashant.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.prashant.driver.DriverManager;
import com.prashant.enums.ConfigProperties;
import com.prashant.utils.PropertyUtils;
import com.prashant.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotRequired) throws Exception {
		if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotBase64()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotRequired) throws Exception {
		if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotBase64()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotRequired) throws Exception {
		if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotBase64()).build());
		} else {
			skip(message);
		}
	}

	

}
