package com.prashant.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.prashant.enums.ConfigProperties;
import com.prashant.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			} else {
                throw new IllegalArgumentException("Browser type " + browser + " is not supported.");
            }

			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
