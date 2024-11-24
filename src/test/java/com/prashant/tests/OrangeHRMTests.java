package com.prashant.tests;
import java.time.Duration;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.util.concurrent.Uninterruptibles;
import com.listeners.RetryFailedTests;
import com.prashant.pages.OrangeHRMLoginPage;
import com.prashant.reports.ExtentReport;
import com.prashant.reports.ExtentReportManager;
import com.prashant.utils.DataProvideUtils;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
		
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProvideUtils.class,retryAnalyzer = RetryFailedTests.class)
	public void loginLogoutTest(Map<String,String> data)  {
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

		String title= new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).login()
				.cliclProFileMenu().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

   
 }
	
	
	@Test(dataProvider = "getData", dataProviderClass = DataProvideUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void demoTest(Map<String,String> data)  {
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

		String title= new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).login()
				.cliclProFileMenu().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

   
 }
	
	

}
