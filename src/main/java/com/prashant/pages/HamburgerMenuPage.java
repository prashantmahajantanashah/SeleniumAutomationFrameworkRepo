package com.prashant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.Uninterruptibles;
import com.prashant.driver.DriverManager;
import com.prashant.enums.WaitStrategy;
import com.prashant.utils.DynamicXpathUtils;

public final class HamburgerMenuPage extends BasePage{
	
	
	public HamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath="//div[text()='Mobiles, Computers']/parent::a")
	private WebElement linkMobileAndComputers;
	
	private String hamburgerSubmenu="//a[text()='%s']";
	
	public LaptopPage clickHamburgerSubmenu(String value) {
		shortWait();
		String newXpath=DynamicXpathUtils.getXpath(hamburgerSubmenu, value);
		if(newXpath.contains("Laptops")) {
				clickElementUsingJS(DriverManager.getDriver().findElement(By.xpath(newXpath)), "laptopLink");
				return new LaptopPage();
		}
		return null;
	}
	
	public HamburgerMenuPage clickMObileAndComputers() {
		clickElementUsingJS(linkMobileAndComputers, "linkMobileAndComputers");
		return this;
	} 
	
	
	

}
