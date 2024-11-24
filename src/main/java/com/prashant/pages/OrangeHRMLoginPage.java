package com.prashant.pages;

import org.openqa.selenium.By;

import com.prashant.driver.DriverManager;
import com.prashant.enums.WaitStrategy;
import com.prashant.reports.ExtentLogger;
import com.prashant.reports.ExtentReport;
import com.prashant.reports.ExtentReportManager;

public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textboxUsername= By.name("username");
	
	private final By textboxPassword= By.xpath("//*[@type='password' and @name='password']");
	
	private final By btnLogin=By.xpath("//*[@type='submit']");
	
	
	public OrangeHRMLoginPage enterUserName(String username) {
		enterText(textboxUsername, username ,WaitStrategy.PRESENCE, "username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		enterText(textboxPassword, password ,WaitStrategy.PRESENCE, "password");
		return this;
	}
	
	public OrangeHRMHomePage login() {
		clickElement(btnLogin, WaitStrategy.PRESENCE, "login");
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
