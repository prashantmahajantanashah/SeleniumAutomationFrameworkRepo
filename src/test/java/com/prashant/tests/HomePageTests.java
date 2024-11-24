package com.prashant.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.text.Element;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prashant.constants.FrameworkConstants;
import com.prashant.driver.Driver;
import com.prashant.driver.DriverManager;

public final class HomePageTests extends BaseTest {
//	Thumb rules
//	1. Never hardcode.
//	2. Keep the right things in right place.
//	3. Religiously practice the Reuse culture.
//	4. Make the framework easy for manual testers or others to contribute.
//	5. Make the framework - Robust

	private HomePageTests() {

	}
	/*
	 * Validate: Title of page is contains Google search/google search Validate that
	 * the title is not null and length of title is >15 and less that 100 Check for
	 * the links in the page-->Testing mini bytes number of links displayed is
	 * exactly 10 or 15
	 */

	@Test
	public void test2() throws Exception {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		Thread.sleep(3000);
		String title = DriverManager.getDriver().getTitle();
		assertThat(title)
		.containsIgnoringCase("google search")
		.isNotNull()
		.hasSizeBetween(15, 100);
		
		System.out.println("title is " + title);
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		// w means any alphabet from a-zA-Z and * means how many times and it should end
		// with google search
		Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "google search"));
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.length() > 15 && title.length() < 100);
		List<WebElement> listOfLinks = new ArrayList();
		listOfLinks = DriverManager.getDriver().findElements(By.xpath("//a/h3"));
		
		assertThat(listOfLinks)
		.as("size is too small").hasSize(10)
		.isNotEmpty()
		.extracting(e-> e.getText())
		.as("does not contain this text").contains("Testing Mini Bytes");
		
		//can remove this if using assertJ assertions
		System.out.println("The numver of links are: " + listOfLinks.size());
		boolean isElementPresent = false;
		for (WebElement e : listOfLinks) {
			if (e.getText().equalsIgnoreCase("Testing Mini Bytes")) {

				System.out.println(e.getText());
				isElementPresent = true;
				break;
			}

		}
		Assert.assertTrue(isElementPresent, "Testing mini bytes not found");

	}

}
