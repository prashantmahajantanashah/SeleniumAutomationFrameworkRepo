package com.prashant.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo {

	@Test
	public void extentDemo() throws IOException {

		/*
		 * The ExtentReports report client for starting reporters and building reports.
		 * For most applications, you should have one ExtentReports instance for the
		 * entire JVM. ExtentReports itself does not build any reports, but allows
		 * reporters to access information, which in turn create the reports. An example
		 * of building an HTML report and adding information to ExtentX:
		 */

		

		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(spark);

		spark.config().setReportName("Report Testing");// will show on the right side top

		spark.config().setTheme(Theme.STANDARD);

		spark.config().setDocumentTitle("Demo report");// will show at the top of the tab
		
		//add test to the report
		ExtentTest test=extent.createTest("chekIfSKFShareIsundervaluedTest");
		
		test.pass("Test passed! yes stock is undervalued");
	
		
		ExtentTest test1=extent.createTest("checkIfNewLogoIsDisplayed");
		
		test1.fail("no! the new logo does not appear! Test failed");
		
		//flush the reports
		extent.flush();//to generate the report
		
		Desktop.getDesktop().browse(new File("index.html").toURI());
		
		
//		ExtentReport.initReports();
//		ExtentReport.createTest("checkIfNewLogoIsDisplayed");
//		ExtentReport.createTest("checkIfNewLogoIsDisplayed");
		
		
		

	}

}
