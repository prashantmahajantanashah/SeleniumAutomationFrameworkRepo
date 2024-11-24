package com.prashant.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.listeners.RetryFailedTests;
import com.prashant.annotations.FrameworkAnnotation;
import com.prashant.enums.CategoryType;
import com.prashant.pages.AmazonHomePage;
import com.prashant.reports.ExtentReportManager;
import com.prashant.utils.DataProvideUtils;

public class AmazonPageTest extends BaseTest{
	
	@FrameworkAnnotation(author={"Prashant","Sachin"}, category= {CategoryType.REGRESSION, CategoryType.SANITY})
	@Test(dataProvider = "getData", dataProviderClass = DataProvideUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void AmazonPageTest(Map<String,String> data) {
		
		String title=new AmazonHomePage().clickHamburger().clickMObileAndComputers().clickHamburgerSubmenu(data.get("submenutext")).getLaptopPageTitle();
		
		Assertions.assertThat(title)
		.isNotNull();
		
		
	}

}
