package com.prashant.pages;
import org.openqa.selenium.By;
import com.prashant.enums.WaitStrategy;
import com.prashant.reports.ExtentLogger;
import com.prashant.reports.ExtentReportManager;

public final class OrangeHRMHomePage extends BasePage{
	
	private final By btnProfileDropdown=By.xpath("//span[@class='oxd-userdropdown-tab']");
	
	private final By linkAbout=By.xpath("//*[text()='About']");
	
	private final By linkSupport=By.xpath("//*[text()='Support']");
	
	private final By linkChangePassword=By.xpath("//*[text()='Change Password']");
	
	private final By linkLogout=By.xpath("//*[text()='Logout']");
	
	
	
	public OrangeHRMHomePage cliclProFileMenu() {
		clickElement(btnProfileDropdown, WaitStrategy.PRESENCE, "profile menu");
		return this;
	}
	
	public OrangeHRMHomePage clickAbout() {
		clickElement(linkAbout,WaitStrategy.PRESENCE, "About");
		return this;
		
	}
	
	public OrangeHRMLoginPage clickLogout() {
		clickElement(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new OrangeHRMLoginPage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
	

}
