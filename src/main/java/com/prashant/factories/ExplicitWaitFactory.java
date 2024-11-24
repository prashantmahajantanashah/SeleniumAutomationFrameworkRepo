package com.prashant.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prashant.constants.FrameworkConstants;
import com.prashant.driver.DriverManager;
import com.prashant.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element=null;
		if(waitStrategy==WaitStrategy.CLICKABLE) {
			element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
			.until(ExpectedConditions.elementToBeClickable(by));
		} 
		else if(waitStrategy==WaitStrategy.PRESENCE) {
//			waitForElementToBePresent(by);
			element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitStrategy==WaitStrategy.VISIBILE) {
//			waitForElementToBePresent(by);
			element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy==WaitStrategy.NONE) {
			element= DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
