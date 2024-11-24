package com.prashant.tests;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.prashant.driver.Driver;
import com.prashant.driver.DriverManager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public final class LoginPageTests extends BaseTest{
	
	
	
	//Never Hardcode
	//Keep things at right place
	
	//className or Interface name= PrashantMahajan
	//mthod name = prashantMahajan
	//package name = prashantmahajan
	//final constant values = PRASHANT_MAHAJAN or PRASHANTMAHAJAN
	//all constants will be stored in src/main/java after creating a package com.prashant.constants
	
	private LoginPageTests(){
		
	}

	
	@Test
	public void test1() throws Exception {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		
	}
	

	

}
