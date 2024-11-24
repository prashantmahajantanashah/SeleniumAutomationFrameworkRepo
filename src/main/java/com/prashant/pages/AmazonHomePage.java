package com.prashant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prashant.driver.DriverManager;

public final class AmazonHomePage extends BasePage{
	
	public AmazonHomePage() {
		
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(id="nav-hamburger-menu")
	private WebElement linkHamburger;
	
	public HamburgerMenuPage clickHamburger() {
		
		linkHamburger.click();
		shortWait();
		return new HamburgerMenuPage();
	}

}
