package com.prashant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;
import com.prashant.driver.DriverManager;
import com.prashant.enums.WaitStrategy;
import com.prashant.factories.ExplicitWaitFactory;
import com.prashant.reports.ExtentLogger;

public class BasePage {
	
	protected void clickElement(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		try {
			ExtentLogger.pass(elementName + " is clicked", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void enterText(By by, String str, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(str);
		try {
			ExtentLogger.pass(str +" is entered successfully in " + elementName, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void scrollToElement(WebElement ele, String elementName) {
		JavascriptExecutor js= ((JavascriptExecutor)DriverManager.getDriver());
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		ExtentLogger.pass("scrolled to element: "+ elementName);
	}
	
	protected void clickElementUsingJS(WebElement ele, String elementName) {
		scrollToElement(ele, elementName);
		shortWait();
		JavascriptExecutor js =(JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", ele);
		try {
			ExtentLogger.pass(elementName + " is clicked", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void shortWait() {
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
	}
	
	
	

}
