package com.prashant.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.prashant.constants.FrameworkConstants;
import com.prashant.enums.CategoryType;

public final class ExtentReport {
	
	private ExtentReport() {
		
	}
	
	private static ExtentReports extent;
	
//	public static ExtentTest test;
	
	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
		
		extent = new ExtentReports();
//		ExtentReports extent = new ExtentReports();

		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());

		extent.attachReporter(spark);

		spark.config().setReportName("Report Testing");// will show on the right side top

		spark.config().setTheme(Theme.STANDARD);

		spark.config().setDocumentTitle("Demo report");// will show at the top of the tab
		}
	}
	
	
	public static void createTest(String testCaseName) {
		ExtentTest test= extent.createTest(testCaseName);
		ExtentReportManager.setExtentTest(test);
	}
	
	
	
	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentReportManager.unload();
//		Desktop.getDesktop().browse(new File("index.html").toURI());
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addAuthorToTest(String[] authors) {
		for(String author: authors) {
			ExtentReportManager.getExtentTest().assignAuthor(author);
		}
		}
		
	public static void addCategoryToTest(CategoryType[] categories) {
		for(CategoryType category: categories) {
			ExtentReportManager.getExtentTest().assignCategory(category.toString());
		}
	}
	
	

}
